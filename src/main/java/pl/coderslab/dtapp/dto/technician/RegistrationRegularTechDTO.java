package pl.coderslab.dtapp.dto.technician;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RegistrationRegularTechDTO {
    private long id;
    @NotBlank
    @Size(min = 3)
    private String firstName;
    @NotBlank
    @Size(min = 3)
    private String lastName;
    @Email
    private String email;
    private String password;
    private Long laboratoryId;
    private String phoneNumber;
}
