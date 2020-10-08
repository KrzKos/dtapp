package pl.coderslab.dtapp.services;

import javassist.NotFoundException;
import pl.coderslab.dtapp.domain.entities.Cases;
import pl.coderslab.dtapp.dto.cases.CasesDTO;

public interface CasesDeleteService {
    CasesDTO findById(Long id);
    void remove(CasesDTO casesDTO) throws NotFoundException;
}
