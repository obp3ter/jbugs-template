package ro.msg.edu.jbugs.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "permissions")
@NamedQueries({
        @NamedQuery(name = Permission.GET_ALL_PERMISSIONS, query = "select p from Permission p")
})
public class Permission extends BaseEntity{
    public static final String GET_ALL_PERMISSIONS = "get all permissions";
    private String description;
    private String type;

    @ManyToMany
    @JoinTable(
            name = "roles_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Role> roles =new HashSet<>();


    public Integer getID() {
        return super.getID();
    }

    public void setID(Integer ID) {
        super.setID(ID);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "ID=" + super.getID() +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", roles=" + roles +
                '}';
    }
}

