package pl.coderslab.dtapp.services;

import pl.coderslab.dtapp.domain.entities.Laboratory;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.dto.laboratory.LaboratoryDTO;
import pl.coderslab.dtapp.dto.technician.TechnicianNameDTO;

public interface LaboratoryService {
    LaboratoryDTO findLaboratoryByTechnician(TechnicianNameDTO technicianDTO);
    LaboratoryDTO getUserLaboratory();
}
