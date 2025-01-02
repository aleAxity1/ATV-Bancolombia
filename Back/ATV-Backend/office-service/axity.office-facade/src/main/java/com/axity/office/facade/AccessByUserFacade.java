package bancolombia.facade;

import bancolombia.commons.DTO.AccessByUserDTO;

import java.util.List;

public interface AccessByUserFacade {
    AccessByUserDTO create(AccessByUserDTO accessByUserDTO);
    List<AccessByUserDTO> readAll();
    AccessByUserDTO read(int id);
    AccessByUserDTO update(AccessByUserDTO accessByUserDTO);
    void delete(int id);
}