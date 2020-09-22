package pl.coderslab.dtapp.services;

import pl.coderslab.dtapp.domain.entities.User;

public interface UserService {

    User findByUserEmail(String email);
}
