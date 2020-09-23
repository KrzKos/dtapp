package pl.coderslab.dtapp.services;

import pl.coderslab.dtapp.domain.entities.Laboratory;
import pl.coderslab.dtapp.domain.entities.User;

public interface LaboratoryService {
    Laboratory findLaboratoryByTechnician(User technician);
}
