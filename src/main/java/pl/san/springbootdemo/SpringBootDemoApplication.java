package pl.san.springbootdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.san.springbootdemo.domain.user.User;
import pl.san.springbootdemo.domain.user.UserService;
import pl.san.springbootdemo.domain.address.Address;
import pl.san.springbootdemo.domain.address.AddressService;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner {

    private final UserService userService;
    private final AddressService addressService;

    public SpringBootDemoApplication(UserService userService, AddressService addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Address address1 = new Address("Lodz", "Krotka 15", "90-050");
        Address address2 = new Address("Lodz", "Długa 15", "90-047");

        User user1 = new User("Janusz", "Kowal", "jankow2", "cokolwiek", true);
        User user2 = new User("Mateusz", "C", "mc2", "cokolwiek", true);
        User user3 = new User("Joanna", "W", "jw2", "cokolwiek", true);
        user1.getAddresses().addAll(Arrays.asList(addressService.save(address1), addressService.save(address2)));
        user2.getAddresses().addAll(Arrays.asList(addressService.save(address1), addressService.save(address2)));
        user3.getAddresses().addAll(Arrays.asList(addressService.save(address1), addressService.save(address2)));

        System.out.println(userService.save(user1));
        System.out.println(userService.save(user2));
        System.out.println(userService.save(user3));
    }
}
