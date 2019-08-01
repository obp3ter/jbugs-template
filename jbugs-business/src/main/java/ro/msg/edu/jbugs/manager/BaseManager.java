package ro.msg.edu.jbugs.manager;

import ro.msg.edu.jbugs.dto.BaseDTO;
import ro.msg.edu.jbugs.model.entity.BaseEntity;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface BaseManager<T extends BaseDTO> {
    void insert(T dto);

    T find(Integer Id);

    List<T> findAll();
}
