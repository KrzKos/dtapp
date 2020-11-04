package pl.coderslab.dtapp.services;

import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.dto.dentist.DentistNameDTO;
import pl.coderslab.dtapp.dto.technician.RegularTechDTO;
import pl.coderslab.dtapp.dto.technician.TechnicianNameDTO;

import java.util.List;

public interface UserService {

    User findByUserEmail(String email);
    List<DentistNameDTO> getAllDentists();
    List<TechnicianNameDTO> getAllTechnician();
    RegularTechDTO findById(long id);
    List<TechnicianNameDTO> getAllFromLabId();
}
