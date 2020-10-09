package pl.coderslab.dtapp.services;

import pl.coderslab.dtapp.dto.technician.RegularTechDTO;

import java.util.List;

public interface RegularTechService {
    List<RegularTechDTO> getRegularTechList();

    void disableTech(RegularTechDTO technicianDTO);

    void changeTechActive(RegularTechDTO technicianDTO, String active);
}
