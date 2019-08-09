package ro.msg.edu.jbugs.dto.mapper;

import ro.msg.edu.jbugs.dto.dto.BaseDTOComplete;
import ro.msg.edu.jbugs.dto.dto.UserDTO;
import ro.msg.edu.jbugs.model.entity.User;

import javax.ejb.Singleton;

@Singleton
public class UserDTOEntityMapper extends BaseDTOEntityMapper<User, UserDTO, BaseDTOComplete> {

    @Override
    public User getEntityFromDTO(UserDTO userDTO)
    {
        User user = new  User();
        //user.setID(userDTO.getID());
        user.setCounter(userDTO.getCounter());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setMobileNumber(userDTO.getMobileNumber());
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        user.setStatus(userDTO.getStatus());
        return user;
    }

    @Override
    public UserDTO getDTOFromEntity(User user)
    {
        UserDTO userDTO = new  UserDTO();
        userDTO.setID(user.getID());
        userDTO.setCounter(user.getCounter());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setMobileNumber(user.getMobileNumber());
        userDTO.setPassword(user.getPassword());
        userDTO.setUsername(user.getUsername());
        userDTO.setStatus(user.getStatus());
        return userDTO;
    }

}
