package pl.coderslab.dtapp.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.dtapp.domain.entities.ConfirmationToken;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {

    ConfirmationToken findByConfirmationToken(String token);
}
