package pl.coderslab.dtapp.services;

import pl.coderslab.dtapp.dto.cases.CasesDetailDTO;

public interface CasesDetailsService {

    CasesDetailDTO getCaseById(Long id);
}
