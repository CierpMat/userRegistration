package pl.san.springbootdemo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.san.springbootdemo.domain.user.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController  //ubsluga requestow http
@RequestMapping(path = "/users")  //mapoj tego path do odpowieniego path servleta
@Slf4j
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    //np. GET localhost:8080/user/2
    @GetMapping(path = "/{id}")
    public UserDTO findById(@PathVariable Long id){
        log.info("log user: " + userService.getLoggedUser());
        User user = userService.findById(id);
        return UserMapper.INSTANCE.toDTO(user);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.delete(id);
    }

    @PostMapping
    public UserInsertDTO insertUser(@RequestBody UserInsertDTO userInsertDTO){
        User userToSave = UserInsertMapper.INSTANCE
                                        .toEntity(userInsertDTO);
        return UserInsertMapper.INSTANCE
                                .toDTO(userService.save(userToSave));
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')") //zastepuje .antMatchers(HttpMethod.GET,"/users").hasAnyAuthority("ADMIN")
    public List<UserDTO> getAllUsers() {
        List<User> allUsers =  userService.getAllUsers();
        return allUsers.stream()
                .map(UserMapper.INSTANCE::toDTO)
                .collect((Collectors.toList()));
    }

}
