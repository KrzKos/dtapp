package pl.coderslab.dtapp.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dtapp.domain.entities.Cases;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.domain.repositories.CaseRepository;
import pl.coderslab.dtapp.services.CasesService;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class CasesServicesImpl implements CasesService {
    private final CaseRepository caseRepository;

    @Override
    public List<Cases> findCasesByTechnicianOrderByCreatedOnDesc(User technician) {
        return caseRepository.findCasesByTechnicianOrderByCreatedOnDesc(technician);
    }
}
