package pl.coderslab.dtapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dtapp.domain.entities.Laboratory;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.dto.CasesDTO;
import pl.coderslab.dtapp.services.CasesService;
import pl.coderslab.dtapp.services.impl.LaboratoryServiceImpl;
import pl.coderslab.dtapp.services.UserService;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/u/cases")
public class CasesController {
    private final UserService userService;
    private final CasesService casesService;
    private final LaboratoryServiceImpl laboratoryServiceImpl;

    @GetMapping
    public String getAllCases(Model model, Principal principal){
        User technician = userService.findByUserEmail(principal.getName());
        if (!technician.getRole().equals("SUPER_TECH")){
            List<CasesDTO> cases = casesService.findCasesByTechnicianOrderByCreatedOnDesc(technician);
            model.addAttribute("cases", cases);
            return "user/cases";
        }
        Laboratory laboratory = laboratoryServiceImpl.findLaboratoryByTechnician(technician);
        model.addAttribute("cases", casesService.findCasesByLaboratory(laboratory));
        return "user/cases";
    }
}
