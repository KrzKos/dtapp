package pl.coderslab.dtapp.controller;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dtapp.dto.cases.CasesEditFormDTO;
import pl.coderslab.dtapp.dto.technician.TechnicianNameDTO;
import pl.coderslab.dtapp.services.CasesService;
import pl.coderslab.dtapp.services.UserService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/u/cases/edit")
public class EditCasesController {
    private final CasesService casesService;
    private final UserService userService;


    @ModelAttribute("technicians")
    public List<TechnicianNameDTO> getAllTechnicians() {
        return userService.getAllTechnician();
    }

    @GetMapping("/{id}")
    private String prepareEditForm(@PathVariable Long id, Model model) throws NotFoundException {
        CasesEditFormDTO caseToEdit = casesService.findCaseById(id);
        model.addAttribute("caseToEdit", caseToEdit);
        return "cases/editForm";
    }
    @PostMapping("/{id}")
    private String updateCase(@PathVariable Long id, @ModelAttribute("caseToEdit") @Valid CasesEditFormDTO casesEditFormDTO) throws NotFoundException {
        casesService.update(casesEditFormDTO);
        return "redirect:/u/cases/detail/{id}";
    }
}
