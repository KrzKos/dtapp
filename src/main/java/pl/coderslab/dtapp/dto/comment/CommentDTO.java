package pl.coderslab.dtapp.dto.comment;

import lombok.Data;
import pl.coderslab.dtapp.domain.entities.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CommentDTO {

    private long id;
    private String text;
    private User user;
    private LocalDateTime createdOn;

}
