package pl.coderslab.dtapp.services.impl;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.coderslab.dtapp.domain.entities.Cases;
import pl.coderslab.dtapp.domain.repositories.CaseRepository;
import pl.coderslab.dtapp.dto.cases.CasesDTO;
import pl.coderslab.dtapp.services.CasesDeleteService;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class CasesDeleteServiceImpl implements CasesDeleteService {
    private final CaseRepository caseRepository;
    private final ModelMapper modelMapper;

    @Override
    public CasesDTO findById(Long id) {


        Optional<Cases> resultCase = caseRepository.findById(id);
        if (resultCase.isPresent()) {
            CasesDTO casesDTO = modelMapper.map(resultCase.get(), CasesDTO.class);
            return casesDTO;
        }
        return null;
    }

    @Override
    public void remove(CasesDTO casesDTO) throws NotFoundException {
        Cases cases = modelMapper.map(casesDTO, Cases.class);
        if (findById(cases.getId()) == null) {
            throw new NotFoundException("Nie znaleziono obiektu");
        }
        caseRepository.delete(cases);


        /*if(!caseRepository.findById(cases.getId()).isPresent()) {
            throw new NotFoundException("Nie znaleziono obiektu");
        }

        caseRepository.delete(cases);*/
    }
}
