package ro.msg.edu.jbugs.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@NamedQueries({
        @NamedQuery(name = Role.GET_ALL_ROLES, query = "select r from Role r")
})
public class Role extends BaseEntity {
    public static final String GET_ALL_ROLES = "get all roles";
    private String type;

    @ManyToMany(mappedBy = "roles")
    private Set<Permission> permissions =new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<User> users =new HashSet<>();


    public Integer getID() {
        return super.getID();
    }

    public void setID(Integer ID) {
        super.setID(ID);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "ID=" + super.getID() +
                ", type='" + type + '\'' +
                ", roles=" + permissions +
                ", users=" + users +
                '}';
    }
}
