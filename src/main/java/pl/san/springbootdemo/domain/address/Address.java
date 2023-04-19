package pl.san.springbootdemo.domain.address;

import lombok.Getter;
import lombok.Setter;
import pl.san.springbootdemo.domain.common.BaseEntity;
import pl.san.springbootdemo.domain.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "myaddresses")
public class Address extends BaseEntity {

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String postalCode;

    @ManyToMany(mappedBy = "addresses")
    private List<User> users = new ArrayList<>();

    public Address() {
    }

    public Address(String city, String street, String postalCode) {
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }
}
