package ro.msg.edu.jbugs.model.dao;

import ro.msg.edu.jbugs.model.entity.Bug;
import ro.msg.edu.jbugs.model.entity.User;
import ro.msg.edu.jbugs.model.interceptors.LoggingInterceptor;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Stateless
@Interceptors(LoggingInterceptor.class)
public class BugDaoImpl implements BugDao {
    @PersistenceContext(unitName = "jbugs-persistence")
    private EntityManager entityManager;

    @Override
    public Bug findById(Integer Id)
    {
        return entityManager.find(Bug.class,Id);
    }
    @Override
    public Bug insert(Bug user)
    {
        entityManager.persist(user);
        entityManager.flush();
        System.out.println();
        return user;
    }
    @Override
    public List<Bug> findAll()
    {
        Query query = entityManager.createNamedQuery(Bug.GET_ALL_BUGS,Bug.class);
        List resultList = query.getResultList();
        return resultList;
    }

    @Override
    public void remove(Bug entity) {
        entityManager.remove(entity);
        entityManager.flush();
    }

    @Override
    public List<Bug> getByCreatedId(Integer Id)
    {
        User user = new User();
        user.setID(Id);
        TypedQuery<Bug> query = entityManager.createNamedQuery(Bug.GET_BY_CREATED_ID, Bug.class);
        query.setParameter("user",user);
        List resultList = query.getResultList();
        return resultList;
    }

    @Override
    public List<Bug> getByAssignedId(Integer Id)
    {
        User user = new User();
        user.setID(Id);
        TypedQuery<Bug> query = entityManager.createNamedQuery(Bug.GET_BY_ASSIGNED_ID, Bug.class);
        query.setParameter("user",user);
        List resultList = query.getResultList();
        return resultList;
    }

    @Override
    public List<Bug> getByCreatedId(User user)
    {
        TypedQuery<Bug> query = entityManager.createNamedQuery(Bug.GET_BY_CREATED_ID, Bug.class);
        query.setParameter("user",user);
        List resultList = query.getResultList();
        return resultList;
    }

    @Override
    public List<Bug> getByAssignedId(User user)
    {
        TypedQuery<Bug> query = entityManager.createNamedQuery(Bug.GET_BY_ASSIGNED_ID, Bug.class);
        query.setParameter("user",user);
        List resultList = query.getResultList();
        return resultList;
    }

    @Override
    public Integer removeOld()
    {
        Calendar cal = Calendar.getInstance();
        Date date = new java.sql.Date(cal.getTimeInMillis());

        Query query = entityManager.createNamedQuery(Bug.REMOVE_OLD_BUGS);
        query.setParameter("expiryDate",date);
        int update = query.executeUpdate();
        return update;
    }
    @Override
    public Integer closeOld()
    {
        Calendar cal = Calendar.getInstance();
        Date date = new java.sql.Date(cal.getTimeInMillis());

        Query query = entityManager.createNamedQuery(Bug.CLOSE_OLD_BUGS);
        query.setParameter("expiryDate",date);
        int update = query.executeUpdate();
        return update;
    }


}
