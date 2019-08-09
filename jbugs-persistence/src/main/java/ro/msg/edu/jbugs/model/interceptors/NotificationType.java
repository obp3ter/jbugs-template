package ro.msg.edu.jbugs.model.interceptors;

import ro.msg.edu.jbugs.model.entity.BaseEntity;
import ro.msg.edu.jbugs.model.entity.Notification;
import ro.msg.edu.jbugs.model.entity.User;

import java.util.List;

public enum NotificationType {
    WELCOM_NEW_USER("WELCOM_NEW_USER"),
    USER_UPDATED("USER_UPDATED"),
    USER_DELETED("USER_DELETED"),
    BUG_UPDATE("BUG_UPDATE"),
    BUG_CLOSED("BUG_CLOSED"),
    BUG_STATUS_UPDATED("BUG_STATUS_UPDATED"),
    USER_DEACTIVATED("USER_DEACTIVATED");
    private String type;

    NotificationType(final String type)
    {
        this.type=type;
    }

    public String getType(){
        return type;
    }
}
