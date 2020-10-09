package pl.coderslab.dtapp.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.coderslab.dtapp.auth.AuthenticationFacade;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.domain.repositories.LaboratoryRepository;
import pl.coderslab.dtapp.domain.repositories.UserRepository;
import pl.coderslab.dtapp.dto.technician.RegistrationRegularTechDTO;
import pl.coderslab.dtapp.dto.technician.RegularTechDTO;
import pl.coderslab.dtapp.services.CasesService;
import pl.coderslab.dtapp.services.RegularTechService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class RegularTechServiceImpl implements RegularTechService {
    private final LaboratoryRepository laboratoryRepository;
    private final UserRepository userRepository;
    private final AuthenticationFacade authentication;
    private final ModelMapper modelMapper;
    private final CasesService casesService;

    @Override
    public List<RegularTechDTO> getRegularTechList() {
        Long labId = laboratoryRepository.findLaboratoryByTechnician(userRepository.findByEmail(authentication.getAuthentication().getName())).getId();
        List<User> regularTechList = userRepository.findAllByLabId(labId);


        List<RegularTechDTO> regularTechDTOList = regularTechList.stream()
                .map(user -> modelMapper.map(user,RegularTechDTO.class))

                .collect(Collectors.toList());

        for(RegularTechDTO regularTechDTO : regularTechDTOList) {
            regularTechDTO.setCasesNumber(casesService.countCasesByTechnician(regularTechDTO));
        }

        return regularTechDTOList;
    }

    @Override
    public void disableTech(RegularTechDTO technicianDTO) {
        User technician = modelMapper.map(technicianDTO,User.class);

        User technicianToDisable = userRepository.findByEmail(technician.getEmail());
        technicianToDisable.setActive(false);
        userRepository.save(technicianToDisable);

    }

    @Override
    public void changeTechActive(RegularTechDTO technicianDTO, String active) {
        User technician = modelMapper.map(technicianDTO,User.class);
        User technicianToDisable = userRepository.findByEmail(technician.getEmail());
        if("disable".equals(active)) {
            technicianToDisable.setActive(false);
            userRepository.save(technicianToDisable);
        } else if ("enable".equals(active)) {
            technicianToDisable.setActive(true);
            userRepository.save(technicianToDisable);
        }
    }
}
