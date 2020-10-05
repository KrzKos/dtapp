package pl.coderslab.dtapp.services.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.domain.repositories.UserRepository;
import pl.coderslab.dtapp.dto.dentist.DentistNameDTO;
import pl.coderslab.dtapp.dto.technician.TechnicianNameDTO;
import pl.coderslab.dtapp.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

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

}
