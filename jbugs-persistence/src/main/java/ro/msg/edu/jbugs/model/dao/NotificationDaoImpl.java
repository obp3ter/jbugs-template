package ro.msg.edu.jbugs.model.dao;

import ro.msg.edu.jbugs.model.entity.Notification;
import ro.msg.edu.jbugs.model.entity.Notification;
import ro.msg.edu.jbugs.model.interceptors.LoggingInterceptor;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.nio.file.Files;
import java.util.List;

@Stateless
@Interceptors(LoggingInterceptor.class)
public class NotificationDaoImpl implements NotificationDao {
    @PersistenceContext(unitName = "jbugs-persistence")
    private EntityManager entityManager;

    @Override
    public Notification findById(Integer Id)
    {
        return entityManager.find(Notification.class,Id);
    }
    @Override
    public Notification insert(Notification notification)
    {
        entityManager.persist(notification);
        entityManager.flush();
        System.out.println();
        return notification;
    }
    @Override
    public List<Notification> findAll()
    {
        Query query = entityManager.createNamedQuery(Notification.GET_ALL_NOTIFICATIONS,Notification.class);
        List resultList = query.getResultList();
        return resultList;
    }

    @Override
    public void remove(Notification entity) {
        entityManager.remove(entity);
        entityManager.flush();
    }
}
