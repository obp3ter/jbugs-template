package ro.msg.edu.jbugs.model.dao;

import ro.msg.edu.jbugs.model.entity.User;
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
    //@Schedule(minute = "*/1", hour = "*")
    @Override
    public void getUAB()
    {
        Query namedQuery= entityManager.createNamedQuery(User.GET_ASSIGNED_BUGS_NUMBER_FOR_ALL);
        List<Object[]> l = namedQuery.getResultList();
        l.forEach(s->System.out.println("<p> User " + s[0] + " " + s[1] + " created " + s[2] + " bugs.</p>"));
    }
}
