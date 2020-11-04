package pl.coderslab.dtapp.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.dtapp.auth.AuthenticationFacade;
import pl.coderslab.dtapp.domain.entities.Laboratory;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.domain.repositories.LaboratoryRepository;
import pl.coderslab.dtapp.domain.repositories.UserRepository;
import pl.coderslab.dtapp.dto.dentist.DentistNameDTO;
import pl.coderslab.dtapp.dto.technician.RegularTechDTO;
import pl.coderslab.dtapp.dto.technician.TechnicianNameDTO;
import pl.coderslab.dtapp.dto.user.UserDTO;
import pl.coderslab.dtapp.services.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final LaboratoryRepository laboratoryRepository;
    private final AuthenticationFacade authentication;

    @Override
    public User findByUserEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<DentistNameDTO> getAllDentists() {
        List<User> dentists = userRepository.findAllByRole("DENTIST");
        List<DentistNameDTO> dentistNameDTOS = dentists.stream()
                .map(d -> modelMapper.map(d, DentistNameDTO.class))
                .collect(Collectors.toList());
        return dentistNameDTOS;
    }

    @Override
    public List<TechnicianNameDTO> getAllTechnician() {
        List<User> technicians = userRepository.findAllByRole("TECH");
        List<TechnicianNameDTO> technicianNameDTOS = technicians.stream()
                .map(t -> modelMapper.map(t,TechnicianNameDTO.class))
                .collect(Collectors.toList());
        return technicianNameDTOS;
    }

    @Override
    public RegularTechDTO findById(long id) {
        Optional<User> resultUser = userRepository.findById(id);
        return resultUser.map(user -> modelMapper.map(user, RegularTechDTO.class)).orElse(null);
    }

    @Override
    public List<TechnicianNameDTO> getAllFromLabId() {
        String userEmail = authentication.getAuthentication().getName();
        Long labId = laboratoryRepository.findLaboratoryByTechnician(userRepository.findByEmail(userEmail)).getId();
        List<User> technicians = userRepository.findAllByLabId(labId);
        List<TechnicianNameDTO> technicianNameDTOS = technicians.stream()
                .map(t -> modelMapper.map(t,TechnicianNameDTO.class))
                .collect(Collectors.toList());
        return technicianNameDTOS;
    }


}
