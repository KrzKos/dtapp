package pl.coderslab.dtapp.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.coderslab.dtapp.domain.entities.Cases;
import pl.coderslab.dtapp.domain.entities.Comment;
import pl.coderslab.dtapp.domain.repositories.CommentRepository;
import pl.coderslab.dtapp.dto.cases.CasesDetailDTO;
import pl.coderslab.dtapp.dto.comment.CommentDTO;
import pl.coderslab.dtapp.services.CommentService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CommentDTO> getComments(CasesDetailDTO casesDetailDTO) {
        Cases cases = modelMapper.map(casesDetailDTO, Cases.class);
        List<Comment> commentList = commentRepository.findCommentsByCasesOrderByCreatedOnDesc(cases);
        List<CommentDTO> commentDTOS = commentList.stream()
                .map(comment -> modelMapper.map(comment,CommentDTO.class))
                .collect(Collectors.toList());
        if (commentDTOS.isEmpty()){
            return null;
        }
        return commentDTOS;
    }
}
