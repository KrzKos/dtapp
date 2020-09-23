package pl.coderslab.dtapp.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.coderslab.dtapp.domain.entities.Cases;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.domain.repositories.CaseRepository;
import pl.coderslab.dtapp.dto.CasesDTO;
import pl.coderslab.dtapp.services.CasesService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class CasesServicesImpl implements CasesService {
    private final CaseRepository caseRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CasesDTO> findCasesByTechnicianOrderByCreatedOnDesc(User technician) {
        List<Cases> cases = caseRepository.findCasesByTechnicianOrderByCreatedOnDesc(technician);
        List<CasesDTO> casesDTOS = cases.stream().map(c -> modelMapper.map(c, CasesDTO.class))
                .collect(Collectors.toList());
        return casesDTOS;
    }
}
