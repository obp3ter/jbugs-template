package ro.msg.edu.jbugs;

import ro.msg.edu.jbugs.model.dao.BugDao;
import ro.msg.edu.jbugs.model.dao.CommentDao;
import ro.msg.edu.jbugs.model.interceptors.LoggingInterceptor;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
@Interceptors(LoggingInterceptor.class)
public class Cleaner {

    @EJB
    private BugDao bugDao;
    @EJB
    private CommentDao commentDao;

//    @Schedule(minute = "*/1", hour = "*")
    public void clean()
    {
        Integer bugres=bugDao.closeOld();
        Integer commentres=commentDao.removeOld();
//        String message = "Bugs closed: "+ bugres+" \nComments deleted: "+commentres+". ";
//        Email.sendMail("Report", message);
    }
}
