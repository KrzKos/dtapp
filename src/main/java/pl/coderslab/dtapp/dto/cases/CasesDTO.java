package pl.coderslab.dtapp.dto.cases;

import lombok.Data;
import pl.coderslab.dtapp.domain.entities.User;

import java.time.LocalDateTime;

@Data
public class CasesDTO {


    private String patientName;
    private LocalDateTime orderTime;
    private LocalDateTime deadline;
    private LocalDateTime finishTime;
    private User technician;

    public String getTechnicianFullName() {
        return technician.getFirstName() + " " + technician.getLastName();
    }
}
