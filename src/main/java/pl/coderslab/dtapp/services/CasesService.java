package pl.coderslab.dtapp.services;

import pl.coderslab.dtapp.domain.entities.Cases;
import pl.coderslab.dtapp.domain.entities.User;

import java.util.List;

public interface CasesService {
    List<Cases> findCasesByTechnicianOrderByCreatedOnDesc(User technician);
}
