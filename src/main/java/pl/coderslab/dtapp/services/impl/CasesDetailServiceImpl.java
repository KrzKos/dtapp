package pl.coderslab.dtapp.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import pl.coderslab.dtapp.auth.AuthenticationFacade;
import pl.coderslab.dtapp.domain.entities.Cases;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.domain.repositories.CaseRepository;
import pl.coderslab.dtapp.domain.repositories.LaboratoryRepository;
import pl.coderslab.dtapp.domain.repositories.UserRepository;
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
    private final AuthenticationFacade authentication;
    private final UserServiceImpl userService;
    private final LaboratoryRepository laboratoryRepository;

    @Override
    public CasesDetailDTO getCaseById(Long id) {
        User technician = userService.findByUserEmail(authentication.getAuthentication().getName());
        if (authentication.getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("SUPER_TECH"))) {

            Cases caseResult = caseRepository.findByIdAndLaboratory(id,laboratoryRepository.findLaboratoryByTechnician(technician));
            if (caseResult != null) {
                CasesDetailDTO caseById = getCasesDetailDTO(caseResult);
                return caseById;
            }
        } else {
            Cases caseResult = caseRepository.findByIdAndTechnician(id, technician);
            if (caseResult != null) {
                CasesDetailDTO caseById = getCasesDetailDTO(caseResult);
                return caseById;
            }
        }

        return null;
    }

    private CasesDetailDTO getCasesDetailDTO(Cases caseResult) {
        CasesDetailDTO caseById = modelMapper.map(caseResult, CasesDetailDTO.class);
        caseById.setTechnician(caseResult.getTechnician().getFirstName() + " " + caseResult.getTechnician().getLastName());
        caseResult.getTeeth().stream()
                .forEach(t -> {
                    caseById.setToothNumber(t.getNumber());
                    caseById.setToothColor(t.getColor());
                    caseById.setToothProstheticType(t.getProstheticType());
                });
        return caseById;
    }
}
