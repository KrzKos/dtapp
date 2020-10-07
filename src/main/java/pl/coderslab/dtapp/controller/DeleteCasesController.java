package pl.coderslab.dtapp.controller;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dtapp.domain.entities.Cases;
import pl.coderslab.dtapp.services.CasesDeleteService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/u/cases/delete")
public class DeleteCasesController {
    private final CasesDeleteService casesDeleteService;

    @GetMapping("/{id}")
    public String deleteCase(@PathVariable Long id) throws NotFoundException {
        Cases cases = casesDeleteService.findById(id);
       /* casesDeleteService.remove(cases);
        return "messages/deleteSuccess";*/
        try {
            casesDeleteService.remove(cases);
            return "messages/deleteSuccess";
        }
        catch (NotFoundException e){
            e.printStackTrace();
            return "messages/deleteFail";
        }
    }
}
