package pl.coderslab.dtapp.services;

import javassist.NotFoundException;
import pl.coderslab.dtapp.domain.entities.Cases;

public interface CasesDeleteService {
    Cases findById(Long id);
    void remove(Cases cases) throws NotFoundException;
}
