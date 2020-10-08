package pl.coderslab.dtapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dtapp.dto.cases.CasesDetailDTO;
import pl.coderslab.dtapp.services.CasesDetailsService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/u/cases/detail")
public class CasesDetailController {
    private final CasesDetailsService casesDetailsService;

    @GetMapping("/{id}")
    public String showCasesDetail(@PathVariable Long id, Model model) {
        CasesDetailDTO casesDetailDTO = casesDetailsService.getCaseById(id);
        if (casesDetailDTO == null){
            return "error/notFound";
        }
        model.addAttribute("caseById", casesDetailsService.getCaseById(id));
        return "cases/details";
    }
}
