package pl.coderslab.dtapp.services.impl;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.coderslab.dtapp.auth.AuthenticationFacade;
import pl.coderslab.dtapp.domain.entities.Cases;
import pl.coderslab.dtapp.domain.entities.Laboratory;
import pl.coderslab.dtapp.domain.entities.Tooth;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.domain.repositories.CaseRepository;
import pl.coderslab.dtapp.domain.repositories.LaboratoryRepository;
import pl.coderslab.dtapp.domain.repositories.ToothRepository;
import pl.coderslab.dtapp.domain.repositories.UserRepository;
import pl.coderslab.dtapp.dto.cases.CasesDTO;
import pl.coderslab.dtapp.dto.cases.CasesEditFormDTO;
import pl.coderslab.dtapp.dto.cases.CasesFormDTO;
import pl.coderslab.dtapp.services.CasesService;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class CasesServicesImpl implements CasesService {
    private final AuthenticationFacade authentication;
    private final CaseRepository caseRepository;
    private final LaboratoryRepository laboratoryRepository;
    private final ToothRepository toothRepository;
    private final UserRepository userRepository;
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
                .map(c -> modelMapper.map(c, CasesDTO.class))
                .collect(Collectors.toList());
        return casesDTOS;

    }

    @Override
    public CasesEditFormDTO findCaseById(Long id) throws NotFoundException {
        User technician = userRepository.findByEmail(authentication.getAuthentication().getName());
        Cases cases = caseRepository.findByIdAndTechnician(id, technician);

        if (cases == null) {
            throw new NotFoundException("Nie znaleziono zlecenia");
        }
        CasesEditFormDTO caseToEdit = modelMapper.map(cases, CasesEditFormDTO.class);
        cases.getTeeth().stream()
                .forEach(t -> {
                    caseToEdit.setToothNumber(t.getNumber());
                    caseToEdit.setToothColor(t.getColor());
                    caseToEdit.setToothProstheticType(t.getProstheticType());
                });
        return caseToEdit;
    }


    @Override
    public void create(CasesFormDTO casesFormDTO) {
        User user = userRepository.findByEmail(authentication.getAuthentication().getName());

        Long labId = laboratoryRepository.findLaboratoryByTechnician(user).getId();
        Cases cases = modelMapper.map(casesFormDTO, Cases.class);
        Tooth tooth = new Tooth();
        tooth.setColor(casesFormDTO.getToothColor());
        tooth.setNumber(casesFormDTO.getToothNumber());
        tooth.setProstheticType(casesFormDTO.getToothProstheticType());
        List<Tooth> toothList = new ArrayList<>();
        toothList.add(tooth);
        cases.setTeeth(toothList);
        cases.setDeadline(casesFormDTO.getDeadline());

        Optional<User> technician = userRepository.findById(casesFormDTO.getTechnicianId());
        if (technician.isPresent()) {
            cases.setTechnician(technician.get());
        }
        Optional<Laboratory> lab = laboratoryRepository.findById(labId);
        if (lab.isPresent()) {
            cases.setLaboratory(lab.get());
        }
        cases.setId(null);
        caseRepository.save(cases);


    }

    @Override
    public void update(CasesEditFormDTO casesEditFormDTO) throws NotFoundException {
        User technician = userRepository.findByEmail(authentication.getAuthentication().getName());

        Cases caseToEdit = caseRepository.findByIdAndTechnician(casesEditFormDTO.getId(), technician);
        if (caseToEdit == null) {
            throw new NotFoundException("Nie znaleziono zlecenia do edycji");
        }
        Optional<User> casesTechnician = userRepository.findById(casesEditFormDTO.getTechnicianId());
        casesTechnician.ifPresent(caseToEdit::setTechnician);
        caseToEdit.setDeadline(casesEditFormDTO.getDeadline());
        caseToEdit.setPatientName(casesEditFormDTO.getPatientName());
        List<Tooth> toothList = new ArrayList<>();
        Tooth tooth = new Tooth();
        tooth.setNumber(casesEditFormDTO.getToothNumber());
        tooth.setColor(casesEditFormDTO.getToothColor());
        tooth.setProstheticType(casesEditFormDTO.getToothProstheticType());
        toothList.add(tooth);
        caseToEdit.setTeeth(toothList);
        caseToEdit.setNote(casesEditFormDTO.getNote());
        caseRepository.save(caseToEdit);

    }


}
