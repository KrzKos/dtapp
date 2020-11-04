package pl.coderslab.dtapp.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.dto.user.UserDTO;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    List<User> findAllByRole(String role);
    @Query("select l.technician from Laboratory l where l.id = ?1")
    List<User> findAllByLabId(long id);


    // do testów
    boolean existsByFirstName(String firstName);



}
