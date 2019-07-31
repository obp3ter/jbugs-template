package ro.msg.edu.jbugs.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = User.GET_ALL_USERS, query = "select u from User u")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = User.GET_ASSIGNED_BUGS_NUMBER_FOR_ALL, query = "select u.first_name,u.last_name, count(b.CREATED_ID)" +
                " as nrbugs from users u inner join bugs b on u.ID=b.CREATED_ID\n" +
                "group by CREATED_ID")

})
public class User extends BaseEntity{
    public static final String GET_ALL_USERS = "getAllUsers";
    public static final String GET_ASSIGNED_BUGS_NUMBER_FOR_ALL = "get assigned bugs # for all";
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
//    public User(
//            Integer ID,
//            Integer counter,
//            String email,
//            String firstName,
//            String lastName,
//            String mobileNumber,
//            String password,
//            String username,
//            Integer status
//    ){
//        this.ID = ID;
//        this.counter = counter;
//        this.email = email;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.mobileNumber = mobileNumber;
//        this.password = password;
//        this.username = username;
//        this.status = status;
//    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getID().equals(user.getID()) &&
                Objects.equals(getCounter(), user.getCounter()) &&
                getEmail().equals(user.getEmail()) &&
                getFirstName().equals(user.getFirstName()) &&
                getLastName().equals(user.getLastName()) &&
                getMobileNumber().equals(user.getMobileNumber()) &&
                getPassword().equals(user.getPassword()) &&
                getUsername().equals(user.getUsername()) &&
                getStatus().equals(user.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getCounter(), getEmail(), getFirstName(), getLastName(), getMobileNumber(), getPassword(), getUsername(), getStatus());
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
                ", createdBugs=" + createdBugs.toString() +
                ", assignedBugs=" + assignedBugs.toString() +
                '}';
    }
}
