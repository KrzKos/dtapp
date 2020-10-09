package pl.coderslab.dtapp.services.impl;

import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.dtapp.auth.AuthenticationFacade;
import pl.coderslab.dtapp.domain.entities.ConfirmationToken;
import pl.coderslab.dtapp.domain.entities.Laboratory;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.domain.entities.embedable.EmailMessage;
import pl.coderslab.dtapp.domain.repositories.ConfirmationTokenRepository;
import pl.coderslab.dtapp.domain.repositories.LaboratoryRepository;
import pl.coderslab.dtapp.domain.repositories.UserRepository;
import pl.coderslab.dtapp.dto.technician.RegistrationRegularTechDTO;
import pl.coderslab.dtapp.services.AddRegularTechService;
import pl.coderslab.dtapp.services.MailService;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class AddRegularTechServiceImpl implements AddRegularTechService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final AuthenticationFacade authentication;
    private final LaboratoryRepository laboratoryRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final MailService mailService;
    private final ConfirmationTokenRepository confirmationTokenRepository;

    @Override
    public void create(RegistrationRegularTechDTO techDTO) throws IOException, TemplateException {
        if (userRepository.findByEmail(techDTO.getEmail()) != null) {
            throw new IllegalArgumentException("Ten adres email już istnieje");
        }
        User superUser = userRepository.findByEmail(authentication.getAuthentication().getName());
        long labId = laboratoryRepository.findLaboratoryByTechnician(superUser).getId();


        User newUser = modelMapper.map(techDTO, User.class);
        newUser.setPassword(passwordEncoder.encode("pass"));
        newUser.setRole("TECH");
        Long newUserId = userRepository.save(newUser).getId();

        ConfirmationToken confirmationToken = new ConfirmationToken();
        confirmationToken.setConfirmationToken(UUID.randomUUID().toString());
        confirmationToken.setUser(userRepository.findById(newUserId).get());
        confirmationTokenRepository.save(confirmationToken);

        Optional<Laboratory> lab = laboratoryRepository.findById(labId);
        Laboratory laboratory;
        if (lab.isPresent()) {
            laboratory = lab.get();
            if (userRepository.findById(newUserId).isPresent()) {
                laboratory.getTechnician().add(userRepository.findById(newUserId).get());
                laboratoryRepository.save(laboratory);
            }
        }

        String mailConten = "Potwierdź rejestrsację klikając: http://localhost:8080/confirm?token=" + confirmationToken.getConfirmationToken();

        mailService.sendEmail("clkrzyko@gmail.com","clkrzyko@gmail.com","Rejestracja do Dtapp",  mailConten);

    }



    @Override
    public List<RegistrationRegularTechDTO> showAllRegularTechs() {
        Long labId = laboratoryRepository.findLaboratoryByTechnician(userRepository.findByEmail(authentication.getAuthentication().getName())).getId();
        List<User> regularTechList = userRepository.findAllByLabId(labId);
        List<RegistrationRegularTechDTO> regularTechDTOList = regularTechList.stream()
                .map(user -> modelMapper.map(user, RegistrationRegularTechDTO.class))
                .collect(Collectors.toList());
        return regularTechDTOList;
    }

    @Override
    public void confirmAccount(String token) throws IllegalArgumentException {
        ConfirmationToken confirmationToken = confirmationTokenRepository.findByConfirmationToken(token);

        if (confirmationToken == null) {
            throw new IllegalArgumentException("Błędny token");
        }

        User userToActivate = userRepository.findByEmail(confirmationToken.getUser().getEmail());
        userToActivate.setActive(true);
        userRepository.save(userToActivate);

    }
}
