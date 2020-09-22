package pl.coderslab.dtapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.services.TechnicianService;
import pl.coderslab.dtapp.services.UserService;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/u/details")
public class UserDetailsController {
    private final TechnicianService technicianService;
    private final UserService userService;

    @GetMapping
    public String showTechnicianDetails(Principal principal){
        User user = userService.findByUserEmail(principal.getName());

        return "user/details";
    }
}
