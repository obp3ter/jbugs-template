package ro.msg.edu.jbugs.manager;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ro.msg.edu.jbugs.dto.dto.UserDTO;
import ro.msg.edu.jbugs.model.dao.UserDao;
import ro.msg.edu.jbugs.model.entity.User;
import ro.msg.edu.jbugs.model.exception.BusinessException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserManagerImplTest {

    @InjectMocks
    private UserManagerImpl userManager;

    @Mock
    private UserDao userDao;

    public void UserManagerTest() {
        this.userManager = new UserManagerImpl();
    }

    @Test
    public void generateUsername() throws Exception {
        /*
        when(userDao.isUsernameUnique(anyString()))
                .thenReturn(true);
        */
        when(userDao.isUsernameUnique("popesd")).thenReturn(true);
        when(userDao.isUsernameUnique("baloz")).thenReturn(true);

        assertEquals("popesd", userManager.generateUsername("Diana", "Popescu"));
        assertEquals("baloz", userManager.generateUsername("Zsolt", "Balo"));

        verify(userDao, times(4)).isUsernameUnique(anyString());
    }
    @Test
    public void generateUsername2() throws Exception {
        /*
        when(userDao.isUsernameUnique(anyString()))
                .thenReturn(true);
        */
        when(userDao.isUsernameUnique("baloz")).thenReturn(false);
        when(userDao.isUsernameUnique("balozs")).thenReturn(false);
        when(userDao.isUsernameUnique("balozso")).thenReturn(false);
        when(userDao.isUsernameUnique("balozsol")).thenReturn(false);
        when(userDao.isUsernameUnique("balozsolt")).thenReturn(false);
        when(userDao.isUsernameUnique("balozsolt0")).thenReturn(false);
        when(userDao.isUsernameUnique("balozsolt1")).thenReturn(true);

    }

    @Test(expected = Exception.class)
    public void checkUsernameUnique() throws Exception {
        when(userDao.isUsernameUnique("baloz")).thenReturn(false);

        assertEquals("baloz", userManager.generateUsername("Zsolt", "Balo"));
    }

    @Test(expected = BusinessException.class)
    public void login() throws BusinessException {

        when(userDao.login(anyString(),anyString())).thenThrow(BusinessException.class);

        userManager.internalLogin("testlt","asd");

    }

    @Test
    public void login2() throws BusinessException
    {
        when(userDao.login("testfn",DigestUtils.sha256Hex("testptestfn"))).thenReturn(createUser());

        User user = userManager.internalLogin("testfn", "testp");
        assertEquals((Integer) 0, user.getCounter());
        assertEquals("teste",user.getEmail());
        assertEquals("testfn",user.getFirstName());
        assertEquals("testln", user.getLastName());
        assertEquals("testmn", user.getMobileNumber());
        assertEquals("testp", user.getPassword());
        assertEquals("testun",user.getUsername());
        assertEquals((Integer)1, user.getStatus());

    }

    private User createUser()
    {
        User user = new User();
        user.setCounter(0);
        user.setEmail("teste");
        user.setFirstName("testfn");
        user.setLastName("testln");
        user.setMobileNumber("testmn");
        user.setPassword("testp");
        user.setUsername("testun");
        user.setStatus(1);
        return user;
    }

}