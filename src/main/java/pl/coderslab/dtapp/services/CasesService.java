package pl.coderslab.dtapp.services;

import javassist.NotFoundException;
import pl.coderslab.dtapp.domain.entities.Cases;
import pl.coderslab.dtapp.domain.entities.Laboratory;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.dto.cases.CasesDTO;
import pl.coderslab.dtapp.dto.cases.CasesEditFormDTO;
import pl.coderslab.dtapp.dto.cases.CasesFormDTO;

import java.util.List;

public interface CasesService {
    List<CasesDTO> findCasesByTechnicianOrderByCreatedOnDesc(User technician);

    List<CasesDTO> findCasesByLaboratory();

    CasesEditFormDTO findCaseById(Long id) throws NotFoundException;


    void create(CasesFormDTO casesFormDTO);
    void update(CasesEditFormDTO casesEditFormDTO) throws NotFoundException;

}
