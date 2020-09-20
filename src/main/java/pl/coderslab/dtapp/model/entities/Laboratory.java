package pl.coderslab.dtapp.model.entities;

import pl.coderslab.dtapp.model.entities.embedable.Address;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Laboratory extends BaseEntity{

    private String name;
    @Column(name = "tax_number", nullable = false, unique = true)
    private String taxNumber;
    private Address address;
    @OneToMany
    private Set<User> technician;

}
