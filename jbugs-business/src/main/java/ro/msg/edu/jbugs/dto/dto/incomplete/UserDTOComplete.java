package ro.msg.edu.jbugs.dto.dto.incomplete;

import ro.msg.edu.jbugs.dto.dto.BaseDTOComplete;

import java.util.HashSet;
import java.util.Set;

public class UserDTOComplete extends BaseDTOComplete {

    private Integer counter;
    private String email;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String password;
    private String username;
    private Integer status;
    private Set<BugDTOComplete> createdBugs = new HashSet<>();
    private Set<BugDTOComplete> assignedBugs = new HashSet<>();
    private Set<CommentDTOComplete> comments = new HashSet<>();
    private Set<NotificationDTOComplete> notifications =new HashSet<>();
    private Set<RoleDTOComplete> roles = new HashSet<>();
}
