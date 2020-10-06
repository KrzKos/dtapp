package pl.coderslab.dtapp.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.coderslab.dtapp.domain.entities.Cases;
import pl.coderslab.dtapp.domain.repositories.CaseRepository;
import pl.coderslab.dtapp.dto.cases.CasesDetailDTO;
import pl.coderslab.dtapp.services.CasesDetailsService;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class CasesDetailServiceImpl implements CasesDetailsService {
    private final CaseRepository caseRepository;
    private final ModelMapper modelMapper;

    @Override
    public CasesDetailDTO getCaseById(Long id) {
        Optional<Cases> caseResult = caseRepository.findById(id);
        if (caseResult.isPresent()) {
            CasesDetailDTO caseById = modelMapper.map(caseResult.get(), CasesDetailDTO.class);
            caseById.setTechnician(caseResult.get().getTechnician().getFirstName() + " " + caseResult.get().getTechnician().getLastName());
            caseResult.get().getTeeth().stream()
                    .forEach(t -> {
                        caseById.setToothNumber(t.getNumber());
                        caseById.setToothColor(t.getColor());
                        caseById.setToothProstheticType(t.getProstheticType());
                    });
            return caseById;
        }

        return null;
    }
}
