package pl.coderslab.dtapp.dto.technician;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RegistrationRegularTechDTO {
    private long id;
    @NotBlank(message = "{NotBlank.message}")
    @Size(min = 3, message = "{SizeMin3.message}")
    private String firstName;
    @NotBlank(message = "{NotBlank.message}")
    @Size(min = 3, message = "{SizeMin3.message}")
    private String lastName;
    @NotBlank(message = "{NotBlank.message}")
    @Email(message = "{WrongEmail.message}")
    private String email;
    private String password;
    private Long laboratoryId;
    private String phoneNumber;
}
