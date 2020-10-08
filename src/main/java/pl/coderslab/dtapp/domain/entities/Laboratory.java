package pl.coderslab.dtapp.domain.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.dtapp.domain.entities.embedable.Address;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter @Setter @ToString
@Entity
public class Laboratory extends BaseEntity{

    private String name;
    @Column(name = "tax_number", nullable = false, unique = true)
    private String taxNumber;
    private Address address;
    @OneToMany
    @Column(name = "user_id")
    private List<User> technician = new ArrayList<>();

}
