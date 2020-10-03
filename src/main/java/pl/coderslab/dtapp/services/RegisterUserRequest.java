package pl.coderslab.dtapp.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class RegisterUserRequest {
    private String username;
    private String password;
}
