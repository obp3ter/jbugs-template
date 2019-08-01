package ro.msg.edu.jbugs.model.dao;

import ro.msg.edu.jbugs.model.entity.Bug;
import ro.msg.edu.jbugs.model.entity.User;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface BugDao extends BaseDao<Bug> {

    List<Bug> getByCreatedId(Integer Id);

    List<Bug> getByAssignedId(Integer Id);

    List<Bug> getByCreatedId(User user);

    List<Bug> getByAssignedId(User user);

    Integer removeOld();

    Integer closeOld();
}
