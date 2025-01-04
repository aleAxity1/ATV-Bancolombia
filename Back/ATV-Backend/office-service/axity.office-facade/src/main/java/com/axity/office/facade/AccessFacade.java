package com.axity.office.facade;

import com.axity.office.commons.dto.AccessDTO;

import java.util.List;

public interface AccessFacade {
    AccessDTO create(AccessDTO accessDTO);
    List<AccessDTO> readAll();
    AccessDTO read(int id);
    AccessDTO update(AccessDTO accessDTO);
    void delete(int id);
}