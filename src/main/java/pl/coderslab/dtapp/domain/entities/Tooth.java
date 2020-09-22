package pl.coderslab.dtapp.domain.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter @Setter
@Entity
public class Tooth extends BaseEntity{

    private String number;
    private String prostheticType;
    private String color;

}
