package pl.coderslab.dtapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dtapp.dto.technician.RegistrationTechnicianDTO;
import pl.coderslab.dtapp.services.TechnicianService;

import javax.validation.Valid;


@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegistrationController {
    private final TechnicianService technicianService;

    @GetMapping
    public String prepareRegistrationForm(Model model) {
        model.addAttribute("technicianRegistration", new RegistrationTechnicianDTO());
        return "register/form";
    }
    @PostMapping
    public String addNewTechnician(@ModelAttribute("technicianRegistration") @Valid RegistrationTechnicianDTO registrationTechnicianDTO, BindingResult result) {

        if (result.hasErrors()) {
            return "register/form";
        }
        technicianService.register(registrationTechnicianDTO);
        return "redirect:/login";
    }
}
