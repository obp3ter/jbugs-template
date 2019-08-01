package ro.msg.edu.jbugs.manager;


import javafx.util.Pair;
import ro.msg.edu.jbugs.dto.BugDTO;
import ro.msg.edu.jbugs.dto.BugDTOEntityMapper;
import ro.msg.edu.jbugs.dto.UserDTO;
import ro.msg.edu.jbugs.dto.UserDTOEntityMapper;
import ro.msg.edu.jbugs.model.interceptors.LoggingInterceptor;
import ro.msg.edu.jbugs.model.dao.UserDao;
import ro.msg.edu.jbugs.model.entity.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Interceptors(LoggingInterceptor.class)
public class UserManagerImpl implements UserManager {

    @EJB
    private UserDao userDao;

    @EJB
    private UserDTOEntityMapper userMapper;

    @EJB
    private BugDTOEntityMapper bugMapper;

    @Override
    public void insert(UserDTO userDTO)
    {
        User user = userMapper.getEntityFromDTO(userDTO);
        userDao.insert(user);
    }
    @Override
    public UserDTO find(Integer Id)
    {
        return userMapper.getDTOFromEntity(userDao.findById(Id));
    }
    @Override
    public List<UserDTO> findAll()
    {
        List<User> userList = userDao.findAll();
        return userMapper.getDTOsFromEntities(userList);
    }
    @Override
    public Pair<UserDTO,List<BugDTO>> getCreatedBugs(Integer Id)
    {
       User user = userDao.findById(Id);

       return new Pair<>(userMapper.getDTOFromEntity(user),bugMapper.getDTOsFromEntities(user.getCreatedBugs()));
    }
    @Override
    public List<Pair<UserDTO,List<BugDTO>>> getCreatedBugsForAll()
    {
        List<Pair<UserDTO,List<BugDTO>>> resultList = new ArrayList<>();
        userDao.findAll().forEach(s->
                {
                    resultList.add(new Pair<>(userMapper.getDTOFromEntity(s),bugMapper.getDTOsFromEntities(s.getCreatedBugs())));
                }
        );
        return resultList;
    }
    @Override
    public void getUAB()
    {
        userDao.getUAB();
    }

}
