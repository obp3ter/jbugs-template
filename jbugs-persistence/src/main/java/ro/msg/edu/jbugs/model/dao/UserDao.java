package ro.msg.edu.jbugs.model.dao;

import ro.msg.edu.jbugs.model.entity.User;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface UserDao extends BaseDao<User>{
    //@Schedule(minute = "*/1", hour = "*")
    void getUAB();
}
