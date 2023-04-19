package pl.san.springbootdemo.domain.roles;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.san.springbootdemo.domain.common.BaseEntity;
import pl.san.springbootdemo.domain.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
@Getter
@Setter
@ToString(callSuper = true)
public class RoleEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private RoleEnum name;

    private String description;

    @OneToMany(mappedBy = "role")
    private List<User> users;

}
