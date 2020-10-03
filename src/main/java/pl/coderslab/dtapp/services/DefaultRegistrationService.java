package pl.coderslab.dtapp.services;

import lombok.RequiredArgsConstructor;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.domain.repositories.UserRepository;

@RequiredArgsConstructor
public class DefaultRegistrationService implements RegistrationService {

    private final UserRepository userRepository;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        validate(request);
        User user = createUser(request);
        return validResponse(user);
    }

    private void validate(RegisterUserRequest request) {
        if (userRepository.existsByFirstName(request.getUsername())) {
            throw new IllegalStateException("Username with " + request.getUsername() + " already exists");
        }
    }

    private RegisterUserResponse validResponse(User user) {
        return new RegisterUserResponse(user.getId());
    }

    private User createUser(RegisterUserRequest request) {
        User user = new User();
        user.setFirstName(request.getUsername());
        user.setPassword(request.getPassword());
        userRepository.save(user);
        return user;
    }
}
