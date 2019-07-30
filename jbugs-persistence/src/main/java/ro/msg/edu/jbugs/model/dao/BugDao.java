package ro.msg.edu.jbugs.model.dao;

import ro.msg.edu.jbugs.model.entity.Bug;
import ro.msg.edu.jbugs.model.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

@Stateless
public class BugDao {
    @PersistenceContext(unitName = "jbugs-persistence")
    private EntityManager entityManager;

    public Bug findBug(Integer Id)
    {
        return entityManager.find(Bug.class,Id);
    }
    public Bug insertBug(Bug user)
    {
        entityManager.persist(user);
        entityManager.flush();
        System.out.println();
        return user;
    }
    public List<Bug> findALL()
    {
        Query query = entityManager.createNamedQuery(Bug.GET_ALL_BUGS,Bug.class);
        List resultList = query.getResultList();
        return resultList;
    }

    public List<Bug> getByCreatedId(Integer Id)
    {
        User user = new User();
        user.setID(Id);
        TypedQuery<Bug> query = entityManager.createNamedQuery(Bug.GET_BY_CREATED_ID, Bug.class);
        query.setParameter("user",user);
        List resultList = query.getResultList();
        return resultList;
    }

    public List<Bug> getByAssignedId(Integer Id)
    {
        User user = new User();
        user.setID(Id);
        TypedQuery<Bug> query = entityManager.createNamedQuery(Bug.GET_BY_ASSIGNED_ID, Bug.class);
        query.setParameter("user",user);
        List resultList = query.getResultList();
        return resultList;
    }

    public List<Bug> getByCreatedId(User user)
    {
        TypedQuery<Bug> query = entityManager.createNamedQuery(Bug.GET_BY_CREATED_ID, Bug.class);
        query.setParameter("user",user);
        List resultList = query.getResultList();
        return resultList;
    }

    public List<Bug> getByAssignedId(User user)
    {
        TypedQuery<Bug> query = entityManager.createNamedQuery(Bug.GET_BY_ASSIGNED_ID, Bug.class);
        query.setParameter("user",user);
        List resultList = query.getResultList();
        return resultList;
    }


}
