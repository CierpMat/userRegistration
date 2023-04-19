package pl.san.springbootdemo.domain.user;

import lombok.Getter;
import lombok.Setter;
import pl.san.springbootdemo.domain.roles.RoleDTO;

@Getter
@Setter
public class UserInsertDTO extends UserDTO{
    private RoleDTO role;
    private String password;
}
