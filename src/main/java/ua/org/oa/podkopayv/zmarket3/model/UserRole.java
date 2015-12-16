package ua.org.oa.podkopayv.zmarket3.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class UserRole {

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    private Roles role;

    @ManyToMany(mappedBy = "userRoles")
    private Set<User> user = new HashSet<>();

    public UserRole() {
    }

    public UserRole(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

}
