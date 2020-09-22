package pl.coderslab.dtapp.domain.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.dtapp.domain.entities.embedable.Address;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Setter
@Getter
@ToString(exclude = "dentists")
@Entity
@Table(name = "clinics")
public class Clinic extends BaseEntity {

    private String name;
    private String taxNumber;
    private Address address;
    @OneToMany
    private List<User> dentists;
}
