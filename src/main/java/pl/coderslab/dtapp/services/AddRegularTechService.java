package pl.coderslab.dtapp.services;

import freemarker.template.TemplateException;
import pl.coderslab.dtapp.domain.entities.ConfirmationToken;
import pl.coderslab.dtapp.dto.technician.RegistrationRegularTechDTO;

import java.io.IOException;
import java.util.List;

public interface AddRegularTechService {

    void create(RegistrationRegularTechDTO techDTO) throws IOException, TemplateException;
    List<RegistrationRegularTechDTO> showAllRegularTechs();
    void confirmAccount(String token);
}
