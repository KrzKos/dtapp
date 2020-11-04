package pl.coderslab.dtapp.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dtapp.domain.entities.Cases;
import pl.coderslab.dtapp.domain.entities.Comment;
import pl.coderslab.dtapp.domain.repositories.CommentRepository;
import pl.coderslab.dtapp.dto.cases.CasesDetailDTO;
import pl.coderslab.dtapp.dto.comment.CommentDTO;
import pl.coderslab.dtapp.services.CasesDetailsService;
import pl.coderslab.dtapp.services.CommentService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/u/cases/detail")
public class CasesDetailController {
    private final CasesDetailsService casesDetailsService;
    private final CommentService commentService;


    @GetMapping("/{id}")
    public String showCasesDetail(@PathVariable Long id, Model model) {
        CasesDetailDTO casesDetailDTO = casesDetailsService.getCaseById(id);
        if (casesDetailDTO == null){
            return "error/notFound";
        }
        List<CommentDTO> comments = commentService.getComments(casesDetailDTO);
        model.addAttribute("comment", new CommentDTO());
        model.addAttribute("comments", comments);
        model.addAttribute("caseById", casesDetailDTO);
        return "cases/details";
    }

    @PostMapping("/{id}")
    public String addComment(@PathVariable long id, @ModelAttribute("comment") CommentDTO commentDTO) {
        CasesDetailDTO caseToComment = casesDetailsService.getCaseById(id);

        casesDetailsService.addComment(commentDTO, caseToComment);
        return "redirect:/u/cases/detail/"+ id;
    }

}
