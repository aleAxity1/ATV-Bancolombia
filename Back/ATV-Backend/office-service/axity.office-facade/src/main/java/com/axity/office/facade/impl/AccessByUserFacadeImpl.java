package com.axity.office.facade.impl;

import com.axity.office.commons.dto.AccessByUserDTO;
import com.axity.office.facade.AccessByUserFacade;
import com.axity.office.service.AccessByUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccessByUserFacadeImpl implements AccessByUserFacade {

    @Autowired
    private AccessByUserService accessByUserService;

    @Override
    public AccessByUserDTO create(AccessByUserDTO accessByUserDTO) {
        return accessByUserService.create(accessByUserDTO);
    }

    @Override
    public List<AccessByUserDTO> readAll() {
        return accessByUserService.readAll();
    }

    @Override
    public AccessByUserDTO read(int id) {
        return accessByUserService.read(id);
    }

    @Override
    public AccessByUserDTO update(AccessByUserDTO accessByUserDTO) {
        return accessByUserService.update(accessByUserDTO);
    }

    @Override
    public void delete(int id) {
        accessByUserService.delete(id);
    }
}