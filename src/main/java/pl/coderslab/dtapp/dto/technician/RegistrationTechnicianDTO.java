package pl.coderslab.dtapp.dto.technician;

import lombok.Data;
import org.hibernate.validator.constraints.pl.NIP;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class RegistrationTechnicianDTO {

    private String email;
    private String password;
    private String rePassword;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    private String labName;
    @NIP
    private String labTaxNumber;
    private String labStreet;
    private String labStreetNumber;
    private String labLocalNumber;
    private String labPostCode;
    private String labCity;
    private String labCountry;
}
