package pl.san.springbootdemo.domain.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.san.springbootdemo.domain.roles.RoleRepository;
import pl.san.springbootdemo.domain.user.UserRepository;
import pl.san.springbootdemo.domain.user.UserService;
import pl.san.springbootdemo.domain.address.AddressRepository;

@Configuration
public class BeanConfiguration {

    @Bean
    public UserService getUserService(UserRepository userRepository, AddressRepository addressRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository) {
        return new UserService(userRepository, addressRepository, bCryptPasswordEncoder, roleRepository);
    }
}
