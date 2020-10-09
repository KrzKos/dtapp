package pl.coderslab.dtapp.dto.technician;

import lombok.Data;

@Data
public class RegularTechDTO {
    private long id;
    private String firstName;
    private String lastName;
    private long casesNumber;
    private String email;
    private String phoneNumber;
    private boolean active;
}
