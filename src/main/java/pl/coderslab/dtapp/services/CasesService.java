package pl.coderslab.dtapp.services;

import pl.coderslab.dtapp.domain.entities.Cases;
import pl.coderslab.dtapp.domain.entities.Laboratory;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.dto.cases.CasesDTO;
import pl.coderslab.dtapp.dto.cases.CasesFormDTO;

import java.util.List;

public interface CasesService {
    List<CasesDTO> findCasesByTechnicianOrderByCreatedOnDesc(User technician);

    List<CasesDTO> findCasesByLaboratory(Laboratory laboratory);

    void create(CasesFormDTO casesFormDTO);
}
