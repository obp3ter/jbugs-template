package ro.msg.edu.jbugs.manager;


import javafx.util.Pair;
import org.apache.commons.codec.digest.DigestUtils;
import ro.msg.edu.jbugs.dto.dto.BugDTO;
import ro.msg.edu.jbugs.dto.mapper.BugDTOEntityMapper;
import ro.msg.edu.jbugs.dto.dto.UserDTO;
import ro.msg.edu.jbugs.dto.mapper.UserDTOEntityMapper;
import ro.msg.edu.jbugs.model.exception.BusinessException;
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
    private NotificationManager notificationManager;

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
        user.setUsername(generateUsername(user.getFirstName(),user.getLastName()));
        user.setPassword(DigestUtils.sha256Hex((user.getPassword()+user.getUsername())));
        user = userDao.insert(user);
        notificationManager.newWelcomeUserNotification(user);
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
    public void removeById(Integer Id) {
        User user = userDao.findById(Id);
        userDao.remove(user);
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

    @Override
    public UserDTO login(String username, String password) throws BusinessException {
        User user = internalLogin(username,password);
        return userMapper.getDTOFromEntity(user);
    }

    public User internalLogin(String username, String password) throws BusinessException {
        password = DigestUtils.sha256Hex((password+username));
        return userDao.login(username,password);
    }

    public String generateUsername(String firstName, String lastName){
        String aux;
        if(lastName.length() >= 5) {
            aux = lastName.substring(0, 5);
        }
        else{
            aux = lastName;
        }
        Integer charPosition = 0;
        String username = (aux + firstName.charAt(charPosition)).toLowerCase();
        while(!userDao.isUsernameUnique(username) && charPosition++<firstName.length()-1){
//            throw new Exception("username not unique");
                username = (username + firstName.charAt(charPosition)).toLowerCase();
        }
        if(!userDao.isUsernameUnique(username) && charPosition==firstName.length())
        {
            Integer idn = 0;
            String tempUsername = (username + idn).toLowerCase();
            idn++;
            while(!userDao.isUsernameUnique(tempUsername))
            {
                tempUsername = (username + idn++).toLowerCase();
            }
            username=tempUsername;
        }

        return username;
    }


    public User addUsername(User user){
        user.setUsername(generateUsername(user.getFirstName(),user.getLastName()));
        return user;
    }
}
