package ro.msg.edu.jbugs.model.dao;

import ro.msg.edu.jbugs.model.entity.BaseEntity;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface BaseDao<T extends BaseEntity> {
    T findById(Integer Id);

    T insert(T entity);

    List<T> findAll();

    void remove(T entity);
}
