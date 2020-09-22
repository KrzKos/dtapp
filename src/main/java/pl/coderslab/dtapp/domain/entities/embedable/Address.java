package pl.coderslab.dtapp.domain.entities.embedable;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {

    private String street;
    private String streetNumber;
    private String localNumber;
    private String postCode;
    private String city;
    private String country;
}
