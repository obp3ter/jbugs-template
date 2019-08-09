package ro.msg.edu.jbugs.dto.mapper;

import ro.msg.edu.jbugs.dto.dto.BaseDTOComplete;
import ro.msg.edu.jbugs.dto.dto.NotificationDTO;
import ro.msg.edu.jbugs.model.entity.Notification;

import javax.ejb.Singleton;

@Singleton
public class NotificationDTOEntityMapper extends BaseDTOEntityMapper<Notification, NotificationDTO, BaseDTOComplete> {

    @Override
    public Notification getEntityFromDTO(NotificationDTO dto) {
        Notification notification = new Notification();
        notification.setMessage(dto.getMessage());
        notification.setType(dto.getType());
        notification.setDate(dto.getDate());
        notification.setUrl(dto.getUrl());
        return notification;
    }

    @Override
    public NotificationDTO getDTOFromEntity(Notification entity) {
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setID(entity.getID());
        notificationDTO.setMessage(entity.getMessage());
        notificationDTO.setType(entity.getType());
        notificationDTO.setDate(entity.getDate());
        notificationDTO.setUrl(entity.getUrl());
        return notificationDTO;
    }
}
