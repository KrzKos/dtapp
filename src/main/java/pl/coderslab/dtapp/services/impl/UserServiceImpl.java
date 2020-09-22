package pl.coderslab.dtapp.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.domain.repositories.UserRepository;
import pl.coderslab.dtapp.services.UserService;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User findByUserEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
