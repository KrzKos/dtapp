package pl.coderslab.dtapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dtapp.domain.entities.Cases;
import pl.coderslab.dtapp.dto.cases.CasesFormDTO;
import pl.coderslab.dtapp.dto.dentist.DentistNameDTO;
import pl.coderslab.dtapp.dto.technician.TechnicianNameDTO;
import pl.coderslab.dtapp.services.CasesService;
import pl.coderslab.dtapp.services.UserService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/u/cases/add")
public class AddCaseController {
    private final UserService userService;
    private final CasesService casesService;

   /* @ModelAttribute("dentists")
    public List<DentistNameDTO> getAllDentists() {
        return userService.getAllDentists();
    }*/

    @ModelAttribute("technicians")
    public List<TechnicianNameDTO> getAllTechnicians() {
        return userService.getAllTechnician();
    }
    @GetMapping
    public String prepareForm(Model model) {
        model.addAttribute("newCase", new CasesFormDTO());
       // model.addAttribute("dentists", getAllDentists());
       return "cases/addForm"; 
    }
    @PostMapping
    @ResponseBody
    public String addCase(@ModelAttribute("newCase") Cases cases) {
        return "Dodano pracę";
    }
}
