package ro.msg.edu.jbugs.model.dao;

import ro.msg.edu.jbugs.model.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserDao {

    @PersistenceContext(unitName = "jbugs-persistence")
    private EntityManager entityManager;

    public User findUser(Integer Id)
    {
        return entityManager.find(User.class,Id);
    }
    public User insertUser(User user)
    {
        entityManager.persist(user);
        entityManager.flush();
        System.out.println();
        return user;
    }
    public List<User> findALL()
    {
        Query query = entityManager.createNamedQuery(User.GET_ALL_USERS,User.class);
        List resultList = query.getResultList();
        return resultList;
    }
}
