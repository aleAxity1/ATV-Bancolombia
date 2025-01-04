package com.axity.office.facade.impl;

import com.axity.office.commons.dto.AccessDTO;
import com.axity.office.facade.AccessFacade;
import com.axity.office.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccessFacadeImpl implements AccessFacade {

    @Autowired
    private AccessService accessService;

    @Override
    public AccessDTO create(AccessDTO accessDTO) {
        return accessService.create(accessDTO);
    }

    @Override
    public List<AccessDTO> readAll() {
        return accessService.readAll();
    }

    @Override
    public AccessDTO read(int id) {
        return accessService.read(id);
    }

    @Override
    public AccessDTO update(AccessDTO accessDTO) {
        return accessService.update(accessDTO);
    }

    @Override
    public void delete(int id) {
        accessService.delete(id);
    }
}