package pl.coderslab.dtapp.services;

import pl.coderslab.dtapp.dto.cases.CasesDetailDTO;
import pl.coderslab.dtapp.dto.comment.CommentDTO;

public interface CasesDetailsService {

    CasesDetailDTO getCaseById(Long id);
    void addComment(CommentDTO commentDTO, CasesDetailDTO casesDetailDTO);

}
