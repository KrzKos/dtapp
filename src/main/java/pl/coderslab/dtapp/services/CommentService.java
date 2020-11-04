package pl.coderslab.dtapp.services;

import pl.coderslab.dtapp.dto.cases.CasesDetailDTO;
import pl.coderslab.dtapp.dto.comment.CommentDTO;

import java.util.List;

public interface CommentService {
    List<CommentDTO> getComments(CasesDetailDTO cases);
}
