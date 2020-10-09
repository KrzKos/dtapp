package pl.coderslab.dtapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.dtapp.services.AddRegularTechService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/confirm")
public class ConfirmController {
    private final AddRegularTechService addRegularTechService;

    @RequestMapping
    public String confirm(@RequestParam("token") String confToken) {
        addRegularTechService.confirmAccount(confToken);
        return "messages/confirmSuccess";
    }
}
