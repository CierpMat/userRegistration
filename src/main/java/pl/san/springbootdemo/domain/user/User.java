package pl.san.springbootdemo.domain.user;

import lombok.*;
import pl.san.springbootdemo.domain.address.Address;
import pl.san.springbootdemo.domain.common.BaseEntity;
import pl.san.springbootdemo.domain.roles.RoleEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "myusers")
public class User extends BaseEntity {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String login;

    private String password;

    @Column(name = "is_active")
    private boolean active;

    @ManyToOne
    private RoleEntity role;

    @ManyToMany
    @JoinTable(name = "users_addresses",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")})
    private List<Address> addresses = new ArrayList<>();

    public User(String firstName, String lastName, String login, String password, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.active = active;
    }
}
