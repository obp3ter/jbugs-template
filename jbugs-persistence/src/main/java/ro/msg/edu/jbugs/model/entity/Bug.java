package ro.msg.edu.jbugs.model.entity;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "bugs")
@NamedQueries({
        @NamedQuery(name = Bug.GET_ALL_BUGS, query = "select b from Bug b"),
        @NamedQuery(name = Bug.GET_BY_CREATED_ID, query = "select b from Bug b where b.CREATED_ID = :user"),
        @NamedQuery(name = Bug.GET_BY_ASSIGNED_ID, query = "select b from Bug b where b.ASSIGNED_ID = :user")
})
public class Bug extends BaseEntity{
    public static final String GET_ALL_BUGS = "get all bugs";
    public static final String GET_BY_CREATED_ID = "get by created id";
    public static final String GET_BY_ASSIGNED_ID = "get by assigned id";
    private String title;
    private String description;
    private String version;
    private Date targetDate;
    private String status;
    private String fixedVersion;
    private String severity;

    @ManyToOne
    @JoinColumn(name = "CREATED_ID", referencedColumnName = "ID")
    private User CREATED_ID;

    @ManyToOne
    @JoinColumn(name = "ASSIGNED_ID", referencedColumnName = "ID")
    private User ASSIGNED_ID;

    public Integer getID() {
        return super.getID();
    }

    public void setID(Integer ID) {
        super.setID(ID);
    }

    public static String getGetAllBugs() {
        return GET_ALL_BUGS;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFixedVersion() {
        return fixedVersion;
    }

    public void setFixedVersion(String fixedVersion) {
        this.fixedVersion = fixedVersion;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public User getCREATED_ID() {
        return CREATED_ID;
    }

    public void setCREATED_ID(User CREATED_ID) {
        this.CREATED_ID = CREATED_ID;
    }

    public User getASSIGNED_ID() {
        return ASSIGNED_ID;
    }

    public void setASSIGNED_ID(User ASSIGNED_ID) {
        this.ASSIGNED_ID = ASSIGNED_ID;
    }

    @Override
    public String toString() {
        return "Bug{" +
                "ID=" + super.getID() +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", version='" + version + '\'' +
                ", targetDate=" + targetDate +
                ", status='" + status + '\'' +
                ", fixedVersion='" + fixedVersion + '\'' +
                ", severity='" + severity + '\'' +
                ", CREATED_ID=" + CREATED_ID +
                ", ASSIGNED_ID=" + ASSIGNED_ID +
                '}';
    }
}
