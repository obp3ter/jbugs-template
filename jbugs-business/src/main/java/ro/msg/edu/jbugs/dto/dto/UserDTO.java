package ro.msg.edu.jbugs.dto.dto;

public class UserDTO extends BaseDTO{

    private Integer counter;
    private String email;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String password;
    private String username;
    private Integer status;

    public UserDTO(
            Integer ID,
            Integer counter,
            String email,
            String firstName,
            String lastName,
            String mobileNumber,
            String password,
            String username,
            Integer status
    ){
        super.setID(ID);
        this.counter = counter;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.username = username;
        this.status = status;
    }

    public UserDTO() {

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

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
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
    public String toString() {
        return "UserDTO{" +
                "ID=" + super.getID() +
                ", counter=" + counter +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", status=" + status +
                '}';
    }
}
