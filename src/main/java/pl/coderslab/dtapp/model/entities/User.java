package pl.coderslab.dtapp.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter @Setter @ToString(exclude = "password")
@Entity
@Table(name = "user")
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
