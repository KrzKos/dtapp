package pl.coderslab.dtapp.dto.technician;

import lombok.Data;

@Data
public class RegistrationRegularTechDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long laboratoryId;
    private String phoneNumber;
}
