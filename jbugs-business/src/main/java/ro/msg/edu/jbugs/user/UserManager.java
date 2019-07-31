package ro.msg.edu.jbugs.user;


import javafx.util.Pair;
import ro.msg.edu.jbugs.dto.BugDTO;
import ro.msg.edu.jbugs.dto.BugDTOEntityMapper;
import ro.msg.edu.jbugs.dto.UserDTO;
import ro.msg.edu.jbugs.dto.UserDTOEntityMapper;
import ro.msg.edu.jbugs.model.dao.UserDao;
import ro.msg.edu.jbugs.model.entity.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Stateless
public class UserManager {

    @EJB
    private UserDao userDao;

    @EJB
    private UserDTOEntityMapper userMapper;

    @EJB
    private BugDTOEntityMapper bugMapper;

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

    public Pair<UserDTO,List<BugDTO>> getCreatedBugs(Integer Id)
    {
       User user = userDao.findUser(Id);

       return new Pair<>(userMapper.getDTOFromEntity(user),bugMapper.getDTOsFromEntities(user.getCreatedBugs()));
    }
    public List<Pair<UserDTO,List<BugDTO>>> getCreatedBugsForAll()
    {
        List<Pair<UserDTO,List<BugDTO>>> resultList = new ArrayList<>();
        userDao.findALL().forEach(s->
                {
                    resultList.add(new Pair<>(userMapper.getDTOFromEntity(s),bugMapper.getDTOsFromEntities(s.getCreatedBugs())));
                }
        );
        return resultList;
    }
    public void getUAB()
    {
        userDao.getUAB();
    }

}
