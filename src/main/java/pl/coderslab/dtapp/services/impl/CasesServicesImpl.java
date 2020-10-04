package pl.coderslab.dtapp.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import pl.coderslab.dtapp.domain.entities.Cases;
import pl.coderslab.dtapp.domain.entities.Laboratory;
import pl.coderslab.dtapp.domain.entities.Tooth;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.domain.repositories.CaseRepository;
import pl.coderslab.dtapp.dto.cases.CasesDTO;
import pl.coderslab.dtapp.dto.cases.CasesFormDTO;
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

    @Override
    public List<CasesDTO> findCasesByLaboratory(Laboratory laboratory) {
        List<Cases> cases = caseRepository.findCasesByLaboratory(laboratory);
        List<CasesDTO> casesDTOS = cases.stream()
                .map(c -> modelMapper.map(c,CasesDTO.class))
                .collect(Collectors.toList());
        return casesDTOS;

    }

    @Override
    public void create(CasesFormDTO casesFormDTO) {
        Cases cases = modelMapper.map(casesFormDTO, Cases.class);

        Tooth tooth = new Tooth();
        tooth.setColor(casesFormDTO.getToothColor());
        tooth.setNumber(casesFormDTO.getToothNumber());
        tooth.setProstheticType(casesFormDTO.getProstheticType());

        caseRepository.save(cases);


    }


}
