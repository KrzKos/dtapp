package pl.coderslab.dtapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dtapp.dto.cases.CasesDTO;
import pl.coderslab.dtapp.services.CasesService;

import java.util.ArrayList;
import java.util.List;

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
    @RequestMapping("/search")
    public String searchName(@RequestParam String name, Model model){
        List<CasesDTO> resultSearch = casesService.findCasesByPatientNameAndLaboratory(name);
        if(resultSearch == null) {
            model.addAttribute("emptyResult", 0);
            return "user/cases";
        }
        model.addAttribute("cases", resultSearch);
        return "user/cases";
    }
}
