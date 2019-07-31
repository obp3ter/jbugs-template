package ro.msg.edu.jbugs.user;


import ro.msg.edu.jbugs.dto.UserDTO;
import ro.msg.edu.jbugs.dto.UserDTOEntityMapper;
import ro.msg.edu.jbugs.model.dao.UserDao;
import ro.msg.edu.jbugs.model.entity.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Set;

@Stateless
public class UserManager {

    @EJB
    private UserDao userDao;

    @EJB
    private UserDTOEntityMapper userMapper;

    public void insertUser(UserDTO userDTO)
    {
        User user = userMapper.getEntityFromDTO(userDTO);
        userDao.insertUser(user);
    }
    public UserDTO find(Integer Id)
    {
        return userMapper.getDTOFromEntity(userDao.findUser(Id));
    }
    public List<UserDTO> findAll()
    {
        List<User> userList = userDao.findALL();
        return userMapper.getDTOsFromEntities(userList);
    }

}
