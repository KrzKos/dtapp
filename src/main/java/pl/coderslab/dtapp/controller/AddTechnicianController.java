package pl.coderslab.dtapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dtapp.dto.technician.RegistrationRegularTechDTO;
import pl.coderslab.dtapp.services.AddRegularTechService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/u/tech")
public class AddTechnicianController {
    private final AddRegularTechService addRegularTechService;

    @ModelAttribute("techList")
    public List<RegistrationRegularTechDTO> showAllRegularTechs() {
        return addRegularTechService.showAllRegularTechs();
    }

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("regularTech", new RegistrationRegularTechDTO());
        return "register/regularTechForm";
    }

    /*@GetMapping("/add")
    public String prepareForm(Model model) {
        model.addAttribute("regularTech", new RegistrationRegularTechDTO());
        return "register/regularTechForm";
    }
*/
    @PostMapping
    public String saveRegularTech(@ModelAttribute("regularTech") @Valid RegistrationRegularTechDTO regularTechDTO,
                                  BindingResult result) {
        if (result.hasErrors()) {
            return "register/regularTechForm";
        }
        addRegularTechService.create(regularTechDTO);
        return "redirect:/user/techList";
    }

}
