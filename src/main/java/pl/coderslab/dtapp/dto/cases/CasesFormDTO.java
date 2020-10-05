package pl.coderslab.dtapp.dto.cases;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Data
public class CasesFormDTO {

    private String patientName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;
    private LocalDate finishTime;
    private String toothNumber;
    private String toothColor;
    private String toothProstheticType;
    private String note;
   // private List<DentistNameDTO> dentist;
    private long technicianId;
    //private long laboratoryId;


}
