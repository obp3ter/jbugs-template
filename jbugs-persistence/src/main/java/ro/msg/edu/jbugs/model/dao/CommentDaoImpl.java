package ro.msg.edu.jbugs.model.dao;

import ro.msg.edu.jbugs.model.entity.Comment;
import ro.msg.edu.jbugs.model.interceptors.LoggingInterceptor;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Stateless
@Interceptors(LoggingInterceptor.class)
public class CommentDaoImpl implements CommentDao {

    @PersistenceContext(unitName = "jbugs-persistence")
    private EntityManager entityManager;

    @Override
    public Comment findById(Integer Id) {
        return entityManager.find(Comment.class, Id);
    }

    @Override
    public Comment insert(Comment comment) {
        entityManager.persist(comment);
        entityManager.flush();
        System.out.println();
        return comment;
    }

    @Override
    public List<Comment> findAll() {
        Query query = entityManager.createNamedQuery(Comment.GET_ALL_COMMENTS, Comment.class);
        List resultList = query.getResultList();
        return resultList;
    }

    @Override
    public void remove(Comment entity) {
        entityManager.remove(entity);
        entityManager.flush();
    }

    @Override
    public Integer removeOld()
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -360);
        Date oneYear = new java.sql.Date(cal.getTimeInMillis());
        Query query = entityManager.createNamedQuery(Comment.REMOVE_OLD_COMMENTS);
        query.setParameter("expiryDate",oneYear);
        int update = query.executeUpdate();
        return update;
    }
}
