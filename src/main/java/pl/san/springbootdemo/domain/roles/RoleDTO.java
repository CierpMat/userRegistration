package pl.san.springbootdemo.domain.roles;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDTO {
    private Long id;
    private String name;
    private String description;
}
