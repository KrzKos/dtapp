package pl.coderslab.dtapp.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.dtapp.domain.entities.Tooth;

@Repository
public interface ToothRepository extends JpaRepository<Tooth, Long> {
}
