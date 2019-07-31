package ro.msg.edu.jbugs.model.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "comments")
@NamedQueries({
        @NamedQuery(name = Comment.REMOVE_OLD_COMMENTS,query = "delete from Comment c where c.date< :expiryDate "),
        @NamedQuery(name = Comment.GET_ALL_COMMENTS, query = "select c from Comment c")
})
public class Comment extends BaseEntity{
    public static final String REMOVE_OLD_COMMENTS = "remove old comments";
    public static final String GET_ALL_COMMENTS = "get all comments";
    private String text;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "ID")
    User user_id;

    @ManyToOne
    @JoinColumn(name = "bug_id", referencedColumnName = "ID")
    Bug bug_id;

    public Integer getID() {
        return super.getID();
    }

    public void setID(Integer ID) {
        super.setID(ID);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Bug getBug_id() {
        return bug_id;
    }

    public void setBug_id(Bug bug_id) {
        this.bug_id = bug_id;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "ID=" + super.getID() +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", user_id=" + user_id +
                ", bug_id=" + bug_id +
                '}';
    }
}
