package pl.coderslab.dtapp.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.dtapp.domain.entities.Cases;
import pl.coderslab.dtapp.domain.entities.Laboratory;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.dto.cases.CasesDTO;
import pl.coderslab.dtapp.dto.laboratory.LaboratoryDTO;
import pl.coderslab.dtapp.dto.technician.RegularTechDTO;

import java.util.List;

@Repository
public interface CaseRepository extends JpaRepository<Cases, Long> {

    List<Cases> findCasesByTechnicianOrderByCreatedOnDesc(User technician);

    List<Cases> findCasesByTechnicianAndLaboratory(User technician, Laboratory laboratory);

    Cases findByIdAndLaboratory(long id, Laboratory laboratory);

    List<Cases> findCasesByLaboratory(Laboratory laboratory);

    Cases findByIdAndTechnician(Long id, User technician);

    long countCasesByTechnician(User technician);
    @Query("select c from Cases c where c.patientName like %:patientName% and c.laboratory = :laboratory and c.technician = :user")
    List<Cases> findByPatientNameAndLaboratory(String patientName, Laboratory laboratory,User user);

    @Query("select c from Cases c where c.patientName like %:patientName% and c.laboratory = :laboratory")
    List<Cases> findByPatientNameForSuperTech(String patientName, Laboratory laboratory);

}
