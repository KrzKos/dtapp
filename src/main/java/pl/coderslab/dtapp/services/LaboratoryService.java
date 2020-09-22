package pl.coderslab.dtapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dtapp.domain.entities.Laboratory;
import pl.coderslab.dtapp.domain.repositories.LaboratoryRepository;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LaboratoryService {
    private final LaboratoryRepository laboratoryRepository;

    public void registerLaboratory(Laboratory laboratory){
        laboratoryRepository.save(laboratory);
    }
}
