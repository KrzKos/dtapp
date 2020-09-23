package pl.coderslab.dtapp.services;
import pl.coderslab.dtapp.domain.entities.Laboratory;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.dto.LaboratoryDTO;
import pl.coderslab.dtapp.dto.RegistrationTechnicianDTO;

import java.util.List;

public interface TechnicianService {


     void register(RegistrationTechnicianDTO registrationTechnician);
     LaboratoryDTO getUserLaboratory(User user);

}