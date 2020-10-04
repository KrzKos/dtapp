package pl.coderslab.dtapp.dto.cases;

import lombok.Data;
import pl.coderslab.dtapp.dto.dentist.DentistNameDTO;
import pl.coderslab.dtapp.dto.technician.TechnicianNameDTO;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CasesFormDTO {

    private String patientName;
    private LocalDateTime deadline;
    private LocalDateTime finishTime;
    private String toothNumber;
    private String toothColor;
    private String prostheticType;
    private String note;
    private List<DentistNameDTO> dentist;
    private List<TechnicianNameDTO> technician;


}
