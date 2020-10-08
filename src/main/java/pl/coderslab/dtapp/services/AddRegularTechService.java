package pl.coderslab.dtapp.services;

import pl.coderslab.dtapp.dto.technician.RegistrationRegularTechDTO;

import java.util.List;

public interface AddRegularTechService {

    void create(RegistrationRegularTechDTO techDTO);
    List<RegistrationRegularTechDTO> showAllRegularTechs();
}
