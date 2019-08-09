package ro.msg.edu.jbugs.dto.dto.incomplete;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class BugDTOComplete {
    private String title;
    private String description;
    private String version;
    private Date targetDate;
    private String status;
    private String fixedVersion;
    private String severity;
    private UserDTOComplete CREATED_ID;
    private UserDTOComplete ASSIGNED_ID;
    private Set<CommentDTOComplete> comments = new HashSet<>();
    private Set<AttachmentDTOComplete> attachments = new HashSet<>();
}
