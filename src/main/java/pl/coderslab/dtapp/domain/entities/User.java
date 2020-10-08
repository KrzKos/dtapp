package pl.coderslab.dtapp.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter @Setter @ToString(exclude = "password")
@Entity
@Table(name = "users")
public class User extends BaseEntity{
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(nullable = false)
    private String password;
    private String role;
    @Column(nullable = false)
    private boolean active = false;

}
