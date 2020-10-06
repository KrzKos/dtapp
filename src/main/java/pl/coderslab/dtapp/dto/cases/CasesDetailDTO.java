package pl.coderslab.dtapp.dto.cases;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CasesDetailDTO {

    private Long id;
    private String patient;
    private String technician;
    private String note;
    private String toothNumber;
    private String toothColor;
    private String toothProstheticType;
    private LocalDate deadLine;
    private LocalDateTime createdOn;

}
