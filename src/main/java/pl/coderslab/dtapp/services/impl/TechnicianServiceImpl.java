package pl.coderslab.dtapp.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.dtapp.domain.entities.Laboratory;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.domain.entities.embedable.Address;
import pl.coderslab.dtapp.domain.repositories.LaboratoryRepository;
import pl.coderslab.dtapp.domain.repositories.UserRepository;
import pl.coderslab.dtapp.dto.laboratory.LaboratoryDTO;
import pl.coderslab.dtapp.dto.technician.RegistrationTechnicianDTO;
import pl.coderslab.dtapp.services.TechnicianService;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class TechnicianServiceImpl implements TechnicianService {
    private final UserRepository userRepository;
    private final LaboratoryRepository laboratoryRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public void register(RegistrationTechnicianDTO registrationTechnician) {
        log.debug("Registration data to create user: {}", registrationTechnician);
        User user = modelMapper.map(registrationTechnician, User.class);
        log.debug("User after mapping from registrationData: {}", user);
        user.setPassword(passwordEncoder.encode(registrationTechnician.getPassword()));
        user.setActive(true);
        user.setRole("SUPER_TECH");
        userRepository.save(user);
        Laboratory laboratory = new Laboratory();
        laboratory.setName(registrationTechnician.getLabName());
        laboratory.setTaxNumber(registrationTechnician.getLabTaxNumber());
        laboratory.getTechnician().add(user);
        Address address = new Address();
        address.setStreet(registrationTechnician.getLabStreet());
        address.setStreetNumber(registrationTechnician.getLabStreetNumber());
        laboratory.setAddress(address);
        laboratoryRepository.save(laboratory);

    }

    public LaboratoryDTO getUserLaboratory(User user) {
        LaboratoryDTO laboratoryDTO = modelMapper.map(laboratoryRepository.findLaboratoryByTechnician(user), LaboratoryDTO.class);
        return laboratoryDTO;
    }
}
