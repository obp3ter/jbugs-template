package ro.msg.edu.jbugs.dto.dto;

import java.sql.Timestamp;

public class BugDTO extends BaseDTO{
    private String title;
    private String description;
    private String version;
    private Timestamp targetDate;
    private String status;
    private String fixedVersion;
    private String severity;

    @Override
    public String toString() {
        return "BugDTO{" +
                "ID=" + super.getID() +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", version='" + version + '\'' +
                ", targetDate=" + targetDate +
                ", status='" + status + '\'' +
                ", fixedVersion='" + fixedVersion + '\'' +
                ", severity='" + severity + '\'' +
                '}';
    }

    public Integer getID() {
        return super.getID();
    }

    public void setID(Integer ID) {
        super.setID(ID);
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

    public Timestamp getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Timestamp targetDate) {
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
}
