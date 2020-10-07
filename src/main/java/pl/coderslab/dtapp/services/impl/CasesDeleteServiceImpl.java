package pl.coderslab.dtapp.services.impl;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dtapp.domain.entities.Cases;
import pl.coderslab.dtapp.domain.repositories.CaseRepository;
import pl.coderslab.dtapp.services.CasesDeleteService;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class CasesDeleteServiceImpl implements CasesDeleteService {
    private final CaseRepository caseRepository;

    @Override
    public Cases findById(Long id) {
        Optional<Cases> resultCase = caseRepository.findById(id);
        return resultCase.orElse(null);
    }
    @Override
    public void remove(Cases cases) throws NotFoundException {
        if(!caseRepository.findById(cases.getId()).isPresent()) {
            throw new NotFoundException("Nie znaleziono obiektu");
        }
        caseRepository.delete(cases);
    }
}
