package com.axity.office.service.impl;

import com.axity.office.commons.dto.AccessDTO;
import com.axity.office.model.Access;
import com.axity.office.persistence.AccessRepository;
import com.axity.office.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccessServiceImpl implements AccessService {

    @Autowired
    private AccessRepository accessRepository;

    @Override
    public AccessDTO create(AccessDTO accessDTO) {
        Access access = new Access();
        access.setXaid(accessDTO.getXaid());
        access.setXaname(accessDTO.getXaname());
        access = accessRepository.save(access);
        return mapToDTO(access);
    }

    @Override
    public List<AccessDTO> readAll() {
        return accessRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public AccessDTO read(int id) {
        return accessRepository.findById(id).map(this::mapToDTO).orElse(null);
    }

    @Override
    public AccessDTO update(AccessDTO accessDTO) {
        Access access = accessRepository.findById(accessDTO.getXaid()).orElse(null);
        if (access != null) {
            access.setXaname(accessDTO.getXaname());
            access = accessRepository.save(access);
            return mapToDTO(access);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        accessRepository.deleteById(id);
    }

    private AccessDTO mapToDTO(Access access) {
        AccessDTO dto = new AccessDTO();
        dto.setXaid(access.getXaid());
        dto.setXaname(access.getXaname());
        return dto;
    }
}