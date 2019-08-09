package ro.msg.edu.jbugs.model.entity;

import javax.inject.Named;
import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = User.GET_ALL_USERS, query = "select u from User u"),
        @NamedQuery(name = User.IS_USERNAME_UNIQUE, query = "select count(u) from User u where u.username = :username"),
        @NamedQuery(name = User.LOGIN_USER,query = " select u from User u where u.username = :username and u.password=:password and u.status=1"),
        @NamedQuery(name = User.GET_USER_BY_USERNAME, query = " select u from User u where u.username= :username")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = User.GET_ASSIGNED_BUGS_NUMBER_FOR_ALL, query = "select u.first_name,u.last_name, count(b.CREATED_ID)" +
                " as nrbugs from users u inner join bugs b on u.ID=b.CREATED_ID\n" +
                "group by CREATED_ID")

})
public class User extends BaseEntity{
    public static final String GET_ALL_USERS = "getAllUsers";
    public static final String GET_ASSIGNED_BUGS_NUMBER_FOR_ALL = "get assigned bugs # for all";
    public static final String IS_USERNAME_UNIQUE = "is username unique";
    public static final String LOGIN_USER = "login user";
    public static final String GET_USER_BY_USERNAME = "get user by username";
    private Integer counter;
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "mobile_number")
    private String mobileNumber;
    private String password;
    private String username;
    private Integer status;

    @OneToMany(mappedBy = "CREATED_ID", fetch = FetchType.LAZY)
    private Set<Bug> createdBugs = new HashSet<>();

    @OneToMany(mappedBy = "ASSIGNED_ID", fetch = FetchType.LAZY)
    private Set<Bug> assignedBugs = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Notification> notifications =new HashSet<>();

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private Set<Role> roles = new HashSet<>();


    public Set<Bug> getCreatedBugs() {
        return createdBugs;
    }

    public void setCreatedBugs(Set<Bug> createdBugs) {
        this.createdBugs = createdBugs;
    }

    public Set<Bug> getAssignedBugs() {
        return assignedBugs;
    }

    public void setAssignedBugs(Set<Bug> assignedBugs) {
        this.assignedBugs = assignedBugs;
    }

    public Integer getID() {
        return super.getID();
    }

    public void setID(Integer ID) {
        super.setID(ID);
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobilNumber) {
        this.mobileNumber = mobilNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public  void addNotification(Notification notification, Boolean addToNotification)
    {
        if(addToNotification)
            notification.setUser(this,false);
        this.notifications.add(notification);
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + super.getID() +
                ", counter=" + counter +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", status=" + status +
                ", createdBugs=" + createdBugs +
                ", assignedBugs=" + assignedBugs +
                ", comments=" + comments +
                ", notifications=" + notifications +
                ", roles=" + roles +
                '}';
    }
}
