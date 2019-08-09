package ro.msg.edu.jbugs.model.entity;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "notifications")
@NamedQueries({
        @NamedQuery(name = Notification.GET_ALL_NOTIFICATIONS, query = "select n from Notification n")
})
public class Notification extends BaseEntity{
    public static final String GET_ALL_NOTIFICATIONS = "get all notifications";
    private Timestamp date;
    private String message;
    private String type;
    private String url;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "ID")
    private User user;

    public Integer getID() {
        return super.getID();
    }

    public void setID(Integer ID) {
        super.setID(ID);
    }


    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user, Boolean addToUser) {
        if(addToUser)
            user.addNotification(this,false);
        this.user = user;
        }

    @Override
    public String toString() {
        return "Notification{" +
                "ID=" + super.getID() +
                ", date=" + date +
                ", message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", user=" + user +
                '}';
    }
}
