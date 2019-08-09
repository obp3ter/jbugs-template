package ro.msg.edu.jbugs.dto.dto;

import ro.msg.edu.jbugs.dto.dto.BaseDTO;

import java.sql.Timestamp;

public class NotificationDTO extends BaseDTO {
    private Timestamp date;
    private String message;
    private String type;
    private String url;

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

    @Override
    public String toString() {
        return "NotificationDTO{" +
                "ID=" + super.getID() +
                ", date=" + date +
                ", message='" + message + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
