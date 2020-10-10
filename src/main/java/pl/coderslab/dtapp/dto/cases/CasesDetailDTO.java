package pl.coderslab.dtapp.dto.cases;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.dtapp.domain.entities.Comment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CasesDetailDTO {

    private Long id;
    private String patient;
    private String technician;
    private String note;
    private String toothNumber;
    private String toothColor;
    private String toothProstheticType;
    private List<Comment> comments;
    private LocalDate deadLine;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime createdOn;

}
