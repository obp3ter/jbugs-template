package ro.msg.edu.jbugs.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ro.msg.edu.jbugs.dto.dto.UserDTO;
import ro.msg.edu.jbugs.manager.UserManager;
import ro.msg.edu.jbugs.model.entity.User;
import ro.msg.edu.jbugs.model.interceptors.LoggingInterceptor;

import javax.ejb.EJB;
import javax.interceptor.Interceptors;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Interceptors(LoggingInterceptor.class)
public class UserService {
    @EJB
    private UserManager userManager;


    @GET
    public List<UserDTO> getAll(){
        return userManager.findAll();
    }
}
