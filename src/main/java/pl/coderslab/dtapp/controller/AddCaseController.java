package pl.coderslab.dtapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dtapp.auth.AuthenticationFacade;
import pl.coderslab.dtapp.dto.cases.CasesFormDTO;
import pl.coderslab.dtapp.dto.laboratory.LaboratoryDTO;
import pl.coderslab.dtapp.dto.technician.TechnicianNameDTO;
import pl.coderslab.dtapp.services.CasesService;
import pl.coderslab.dtapp.services.LaboratoryService;
import pl.coderslab.dtapp.services.UserService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/u/cases/add")
public class AddCaseController {
    private final AuthenticationFacade authentication;
    private final UserService userService;
    private final CasesService casesService;
    private final LaboratoryService laboratoryService;

   /* @ModelAttribute("dentists")
    public List<DentistNameDTO> getAllDentists() {
        return userService.getAllDentists();
    }*/

    @ModelAttribute("laboratory")
    public LaboratoryDTO getLaboratory() {
        return laboratoryService.getUserLaboratory();
    }

    @ModelAttribute("technicians")
    public List<TechnicianNameDTO> getAllTechnicians() {
        return userService.getAllTechnician();
    }

    @GetMapping
    public String prepareForm(Model model) {
        model.addAttribute("newCase", new CasesFormDTO());
       // model.addAttribute("role", authentication.getAuthentication().getAuthorities());
       return "cases/addForm"; 
    }
    @PostMapping
    public String addCase(@ModelAttribute("newCase") @Valid CasesFormDTO casesFormDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "cases/addForm";
        }
        casesService.create(casesFormDTO);
        return "redirect:/u/cases";
    }
}
