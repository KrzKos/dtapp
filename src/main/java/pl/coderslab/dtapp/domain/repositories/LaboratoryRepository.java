package pl.coderslab.dtapp.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.dtapp.domain.entities.Laboratory;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.dto.LaboratoryDTO;

import java.util.List;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, Long> {
    List<LaboratoryDTO> findLaboratoriesByTechnician(User technician);
}
