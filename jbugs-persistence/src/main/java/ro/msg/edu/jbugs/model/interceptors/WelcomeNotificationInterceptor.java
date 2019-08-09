package ro.msg.edu.jbugs.model.interceptors;

import ro.msg.edu.jbugs.model.dao.NotificationDao;
import ro.msg.edu.jbugs.model.entity.Notification;
import ro.msg.edu.jbugs.model.entity.User;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.sql.Timestamp;
import java.util.Calendar;

//@Interceptor
public class WelcomeNotificationInterceptor {
    @EJB
    private NotificationDao notificationDao;

    @AroundInvoke
    private Object doNotification(InvocationContext ic)
    {

        Object obj = null;
        try{
            User user = (User) ic.getParameters()[0];
//            String type = NotificationType.WELCOM_NEW_USER.getType();
//        String message = "Welcome "+user.getFirstName()+" "+user.getLastName()+", \n"+
//                "Your username is: "+user.getUsername()+", \n"+
//                "Your email is: "+user.getEmail()+", \n"+
//                "Your mobile number is: "+user.getMobileNumber();
//        Notification notification = new Notification();
//        notification.setType(type);
//        notification.setMessage(message);
//        notification.setUser(user,true);
//        notification.setDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
//        notificationDao.insert(notification);
            obj= ic.proceed();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally {
        }
        return obj;

    }
}
