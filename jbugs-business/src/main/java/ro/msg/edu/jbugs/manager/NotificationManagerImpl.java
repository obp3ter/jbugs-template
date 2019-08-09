package ro.msg.edu.jbugs.manager;

import ro.msg.edu.jbugs.dto.dto.NotificationDTO;
import ro.msg.edu.jbugs.dto.mapper.NotificationDTOEntityMapper;
import ro.msg.edu.jbugs.model.dao.NotificationDao;
import ro.msg.edu.jbugs.model.entity.Notification;
import ro.msg.edu.jbugs.model.entity.User;
import ro.msg.edu.jbugs.model.interceptors.LoggingInterceptor;
import ro.msg.edu.jbugs.model.interceptors.NotificationType;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Stateless
@Interceptors(LoggingInterceptor.class)
public class NotificationManagerImpl implements NotificationManager{

    @EJB
    private NotificationDao notificationDao;

    @EJB
    private NotificationDTOEntityMapper notificationMapper;

    @Override
    public void insert(NotificationDTO notificationDTO)
    {
        Notification notification = notificationMapper.getEntityFromDTO(notificationDTO);
        notificationDao.insert(notification);
    }
    @Override
    public NotificationDTO find(Integer Id)
    {
        return notificationMapper.getDTOFromEntity(notificationDao.findById(Id));
    }
    @Override
    public List<NotificationDTO> findAll()
    {
        List<Notification> notificationList = notificationDao.findAll();
        return notificationMapper.getDTOsFromEntities(notificationList);
    }

    @Override
    public void removeById(Integer Id) {
        Notification notification = notificationDao.findById(Id);
        notificationDao.remove(notification);
    }

    @Override
    public void newWelcomeUserNotification(User user) {
        String type = NotificationType.WELCOM_NEW_USER.getType();
        String message = "Welcome "+user.getFirstName()+" "+user.getLastName()+", \n"+
                "Your username is: "+user.getUsername()+", \n"+
                "Your email is: "+user.getEmail()+", \n"+
                "Your mobile number is: "+user.getMobileNumber();
        Notification notification = new Notification();
        notification.setType(type);
        notification.setMessage(message);
        notification.setUser(user,true);
        notification.setDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        notificationDao.insert(notification);
}
}
