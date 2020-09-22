package pl.coderslab.dtapp.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.dtapp.domain.entities.Cases;
import pl.coderslab.dtapp.domain.entities.User;

import java.util.List;

@Repository
public interface CaseRepository extends JpaRepository<Cases, Long> {

    List<Cases> findCasesByTechnicianOrderByCreatedOnDesc(User technician);
}
