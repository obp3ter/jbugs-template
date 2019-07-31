package ro.msg.edu.jbugs.model.dao;

import ro.msg.edu.jbugs.model.entity.Comment;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Stateless
public class CommentDao {

    @PersistenceContext(unitName = "jbugs-persistence")
    private EntityManager entityManager;

    public Comment findComment(Integer Id) {
        return entityManager.find(Comment.class, Id);
    }

    public Comment insertComment(Comment comment) {
        entityManager.persist(comment);
        entityManager.flush();
        System.out.println();
        return comment;
    }

    public List<Comment> findALL() {
        Query query = entityManager.createNamedQuery(Comment.GET_ALL_COMMENTS, Comment.class);
        List resultList = query.getResultList();
        return resultList;
    }
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
