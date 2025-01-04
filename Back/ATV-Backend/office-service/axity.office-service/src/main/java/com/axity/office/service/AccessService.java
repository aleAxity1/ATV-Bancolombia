package com.axity.office.service;

import com.axity.office.commons.dto.AccessDTO;

import java.util.List;

public interface AccessService {
    AccessDTO create(AccessDTO accessDTO);
    List<AccessDTO> readAll();
    AccessDTO read(int id);
    AccessDTO update(AccessDTO accessDTO);
    void delete(int id);
}