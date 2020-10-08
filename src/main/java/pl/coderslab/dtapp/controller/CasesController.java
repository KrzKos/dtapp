package pl.coderslab.dtapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dtapp.services.CasesService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/u/cases")
public class CasesController {
    private final CasesService casesService;

    @GetMapping
    public String getAllCases(Model model){
        model.addAttribute("cases", casesService.findCasesByLaboratory());
        return "user/cases";
    }
}
