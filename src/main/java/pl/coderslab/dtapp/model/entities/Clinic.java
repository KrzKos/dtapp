package pl.coderslab.dtapp.model.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.dtapp.model.entities.embedable.Address;

import javax.persistence.*;
import java.util.List;

@Setter @Getter @ToString(exclude = "dentists")
@Entity
@Table (name = "clinics")
public class Clinic extends BaseEntity {

    private String name;
    private String taxNumber;
    private Address address;
    @OneToMany
    private List<User> dentist;
}
