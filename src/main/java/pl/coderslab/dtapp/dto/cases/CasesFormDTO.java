package pl.coderslab.dtapp.dto.cases;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class CasesFormDTO {
    @NotBlank

    private String patientName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;
    @NotBlank(message = "{NotBlank.message}")
    @Size(min = 2, max = 2, message = "{WrongToothNumber.message}")
    private String toothNumber;
    private String toothColor;
    private String toothProstheticType;
    private String note;
    private long technicianId;


}
