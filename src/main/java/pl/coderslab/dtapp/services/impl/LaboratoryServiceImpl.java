package pl.coderslab.dtapp.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dtapp.domain.entities.Laboratory;
import pl.coderslab.dtapp.domain.entities.User;
import pl.coderslab.dtapp.domain.repositories.LaboratoryRepository;
import pl.coderslab.dtapp.services.LaboratoryService;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LaboratoryServiceImpl implements LaboratoryService {
    private final LaboratoryRepository laboratoryRepository;

    public void registerLaboratory(Laboratory laboratory){
        laboratoryRepository.save(laboratory);
    }
    public Laboratory findLaboratoryByTechnician(User technician){
        return laboratoryRepository.findLaboratoryByTechnician(technician);
    }

}
