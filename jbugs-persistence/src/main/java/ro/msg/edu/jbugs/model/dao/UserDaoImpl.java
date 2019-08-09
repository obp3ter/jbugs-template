package ro.msg.edu.jbugs.model.dao;

import ro.msg.edu.jbugs.model.entity.User;
import ro.msg.edu.jbugs.model.exception.BusinessException;
import ro.msg.edu.jbugs.model.interceptors.LoggingInterceptor;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.*;
import java.util.List;

@Stateless
@Interceptors(LoggingInterceptor.class)
public class UserDaoImpl implements UserDao {

    @PersistenceContext(unitName = "jbugs-persistence")
    private EntityManager entityManager;

    @Override
    public User findById(Integer Id)
    {
        return entityManager.find(User.class,Id);
    }
    @Override
    public User insert(User user)
    {
        entityManager.persist(user);
        entityManager.flush();
        System.out.println();
        return user;
    }
    @Override
    public List<User> findAll()
    {
        Query query = entityManager.createNamedQuery(User.GET_ALL_USERS,User.class);
        List resultList = query.getResultList();
        return resultList;
    }

    @Override
    public void remove(User entity) {
        User reference = entityManager.find(User.class, entity.getID());
        entityManager.remove(reference);
        //entityManager.flush();
        //entityManager.clear();
        entityManager.flush();
    }

    //@Schedule(minute = "*/1", hour = "*")
    @Override
    public void getUAB()
    {
        Query namedQuery= entityManager.createNamedQuery(User.GET_ASSIGNED_BUGS_NUMBER_FOR_ALL);
        List<Object[]> l = namedQuery.getResultList();
        l.forEach(s->System.out.println("<p> User " + s[0] + " " + s[1] + " created " + s[2] + " bugs.</p>"));
    }

    @Override
    public Boolean isUsernameUnique(String username) {
        Query namedQuery = entityManager.createNamedQuery(User.IS_USERNAME_UNIQUE);
        namedQuery.setParameter("username",username);
        Long c = (Long) namedQuery.getSingleResult();
        return c==0;
    }

    @Override
    public User login(String username, String password) throws BusinessException{
        TypedQuery<User> namedQuery = entityManager.createNamedQuery(User.LOGIN_USER, User.class);
        namedQuery.setParameter("username",username);
        namedQuery.setParameter("password",password);
        try {
            User user = namedQuery.getSingleResult();
            user.setCounter(0);
            entityManager.merge(user);
            entityManager.flush();
            return user;
        }catch (NoResultException e)
        {
            try
            {
                TypedQuery<User> namedQuery1 = entityManager.createNamedQuery(User.GET_USER_BY_USERNAME, User.class);
                namedQuery1.setParameter("username",username);
                User user = namedQuery1.getSingleResult();

                if(user.getStatus()==0)
                    throw new BusinessException("problem","Deactivated user!");

                user.setCounter(user.getCounter()+1);
                if(user.getCounter() >= 5)
                    user.setStatus(0);
                entityManager.merge(user);
                entityManager.flush();
            }
            catch (NoResultException ee)
            {
                throw new BusinessException("problem","No user with this username!");
            }


            throw new BusinessException("problem","The password is incorrect!");
        }
    }
}
