package pl.coderslab.dtapp.dto.technician;

import lombok.Data;
import org.hibernate.validator.constraints.pl.NIP;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RegistrationTechnicianDTO {

    @NotBlank(message = "{NotBlank.message}")
    @Email
    private String email;
    @NotBlank(message = "{NotBlank.message}")
    @Size(min=3, max = 30, message = "Min 3 znaki max 30")
    private String password;
    private String rePassword;
    @NotBlank(message = "{NotBlank.message}")
    private String firstName;
    @NotBlank(message = "{NotBlank.message}")
    private String lastName;
    private String phoneNumber;
    @NotBlank(message = "{NotBlank.message}")
    private String labName;

    private String labTaxNumber;
    private String labStreet;
    private String labStreetNumber;
    private String labLocalNumber;
    private String labPostCode;
    private String labCity;
    private String labCountry;
}
