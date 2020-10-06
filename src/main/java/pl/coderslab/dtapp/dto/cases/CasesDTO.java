package pl.coderslab.dtapp.dto.cases;

import lombok.Data;
import pl.coderslab.dtapp.domain.entities.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CasesDTO {

    private Long id;
    private String patientName;
    private LocalDateTime orderTime;
    private LocalDate deadline;
    private LocalDateTime finishTime;
    private User technician;

    public String getTechnicianFullName() {
        return technician.getFirstName() + " " + technician.getLastName();
    }
}
