package ro.msg.edu.jbugs;

import ro.msg.edu.jbugs.Email.Email;
import ro.msg.edu.jbugs.dto.UserDTO;
import ro.msg.edu.jbugs.model.dao.BugDao;
import ro.msg.edu.jbugs.model.dao.CommentDao;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class Cleaner {

    @EJB
    private BugDao bugDao;
    @EJB
    private CommentDao commentDao;

    @Schedule(minute = "*/1", hour = "*")
    public void clean()
    {
        Integer bugres=bugDao.removeOld();
        Integer commentres=commentDao.removeOld();
        String message = "Bugs deleted: "+ bugres+" \nComments deleted: "+commentres+". ";
        Email.sendMail("Report", message);
    }
}
