package pl.coderslab.dtapp.services;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.dto.LaboratoryDTO;
import pl.coderslab.dtapp.dto.RegistrationTechnicianDTO;

public interface TechnicianService {


     void register(RegistrationTechnicianDTO registrationTechnician);
     LaboratoryDTO getUserLaboratory(User user);

}
