package pl.coderslab.dtapp.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.coderslab.dtapp.auth.AuthenticationFacade;
import pl.coderslab.dtapp.domain.entities.Laboratory;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.domain.repositories.LaboratoryRepository;
import pl.coderslab.dtapp.dto.laboratory.LaboratoryDTO;
import pl.coderslab.dtapp.dto.technician.TechnicianNameDTO;
import pl.coderslab.dtapp.services.LaboratoryService;
import pl.coderslab.dtapp.services.UserService;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LaboratoryServiceImpl implements LaboratoryService {
    private final LaboratoryRepository laboratoryRepository;
    private final ModelMapper modelMapper;
    private final AuthenticationFacade authentication;
    private final UserService userService;

    public void registerLaboratory(Laboratory laboratory){
        laboratoryRepository.save(laboratory);
    }

    @Override
    public LaboratoryDTO findLaboratoryByTechnician(TechnicianNameDTO technicianDTO) {
        User technician = modelMapper.map(technicianDTO,User.class);
        LaboratoryDTO laboratoryDTO = modelMapper.map(laboratoryRepository.findLaboratoryByTechnician(technician), LaboratoryDTO.class);
        return laboratoryDTO;
    }

    @Override
    public LaboratoryDTO getUserLaboratory() {
        User technician = userService.findByUserEmail(authentication.getAuthentication().getName());
        Laboratory laboratoryByTechnician = laboratoryRepository.findLaboratoryByTechnician(technician);
        LaboratoryDTO laboratoryDTO = modelMapper.map(laboratoryByTechnician,LaboratoryDTO.class);
        return laboratoryDTO;
    }
}
