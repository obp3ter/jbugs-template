package ro.msg.edu.jbugs.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "attachments")
@NamedQueries({
        @NamedQuery(name = Attachment.GET_ALL_ATTACHMENTS, query = "select a from Attachment a")
})
public class Attachment extends BaseEntity {
    public static final String GET_ALL_ATTACHMENTS = "get all attachments";
    @Column(name = "attContent")
    private String content;

    @ManyToOne
    @JoinColumn(name = "id_bug", referencedColumnName = "ID")
    private Bug id_bug;

    public Integer getID() {
        return super.getID();
    }

    public void setID(Integer ID) {
        super.setID(ID);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Bug getId_bug() {
        return id_bug;
    }

    public void setId_bug(Bug id_bug) {
        this.id_bug = id_bug;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "ID=" + super.getID() +
                ", content='" + content + '\'' +
                ", id_bug=" + id_bug +
                '}';
    }
}
