package ro.msg.edu.jbugs.model.dao;

import ro.msg.edu.jbugs.model.entity.User;
import ro.msg.edu.jbugs.model.exception.BusinessException;

import javax.ejb.Remote;

@Remote
public interface UserDao extends BaseDao<User>{
    //@Schedule(minute = "*/1", hour = "*")
    void getUAB();
    Boolean isUsernameUnique(String username);
    User login(String username, String password) throws BusinessException;
}
