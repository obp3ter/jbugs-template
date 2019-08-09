package ro.msg.edu.jbugs.manager;

import ro.msg.edu.jbugs.dto.dto.NotificationDTO;
import ro.msg.edu.jbugs.model.entity.User;

public interface NotificationManager extends BaseManager<NotificationDTO> {
    void newWelcomeUserNotification(User user);
}
