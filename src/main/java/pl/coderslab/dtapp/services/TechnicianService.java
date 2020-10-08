package pl.coderslab.dtapp.services;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.dto.laboratory.LaboratoryDTO;
import pl.coderslab.dtapp.dto.technician.RegistrationTechnicianDTO;

public interface TechnicianService {


     void register(RegistrationTechnicianDTO registrationTechnician);
     LaboratoryDTO getUserLaboratory(User user);

}
