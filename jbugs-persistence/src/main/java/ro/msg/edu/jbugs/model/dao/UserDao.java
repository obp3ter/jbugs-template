package ro.msg.edu.jbugs.model.dao;

import ro.msg.edu.jbugs.model.entity.User;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

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
    @Schedule(minute = "*/1", hour = "*")
    public void getUAB()
    {
        Query namedQuery= entityManager.createNamedQuery(User.GET_ASSIGNED_BUGS_NUMBER_FOR_ALL);
        List<Object[]> l = namedQuery.getResultList();
        l.forEach(s->System.out.println("<p> User " + s[0] + " " + s[1] + " created " + s[2] + " bugs.</p>"));
    }
}
