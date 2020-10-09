package pl.coderslab.dtapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dtapp.dto.technician.RegularTechDTO;
import pl.coderslab.dtapp.services.RegularTechService;
import pl.coderslab.dtapp.services.UserService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/u/tech/active/")
public class ChangeActiveTechnicianController {
    private final RegularTechService regularTechService;
    private final UserService userService;

    @GetMapping("/{active}/{id}")
    public String disableUser(@PathVariable String active, @PathVariable long id) {
        RegularTechDTO regularTechDTO = userService.findById(id);
        regularTechService.changeTechActive(regularTechDTO, active);
        return "redirect:/u/tech";
    }
}
