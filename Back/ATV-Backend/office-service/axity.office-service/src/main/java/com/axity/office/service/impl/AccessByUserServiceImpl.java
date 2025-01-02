package com.axity.office.service.impl;

import com.axity.office.commons.dto.AccessByUserDTO;
import com.axity.office.model.AccessByUser;
import com.axity.office.persistence.AccessByUserRepository;
import com.axity.office.service.AccessByUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccessByUserServiceImpl implements AccessByUserService {

    @Autowired
    private AccessByUserRepository accessByUserRepository;

    @Override
    public AccessByUserDTO create(AccessByUserDTO accessByUserDTO) {
        AccessByUser accessByUser = new AccessByUser();
        accessByUser.setXacoac(accessByUserDTO.getXacoac());
        accessByUser.setXaname(accessByUserDTO.getXaname());
        accessByUser = accessByUserRepository.save(accessByUser);
        return mapToDTO(accessByUser);
    }

    @Override
    public List<AccessByUserDTO> readAll() {
        return accessByUserRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public AccessByUserDTO read(int id) {
        return accessByUserRepository.findById(id).map(this::mapToDTO).orElse(null);
    }

    @Override
    public AccessByUserDTO update(AccessByUserDTO accessByUserDTO) {
        AccessByUser accessByUser = accessByUserRepository.findById(accessByUserDTO.getXacoac()).orElse(null);
        if (accessByUser != null) {
            accessByUser.setXaname(accessByUserDTO.getXaname());
            accessByUser = accessByUserRepository.save(accessByUser);
            return mapToDTO(accessByUser);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        accessByUserRepository.deleteById(id);
    }

    private AccessByUserDTO mapToDTO(AccessByUser accessByUser) {
        AccessByUserDTO dto = new AccessByUserDTO();
        dto.setXacoac(accessByUser.getXacoac());
        dto.setXaname(accessByUser.getXaname());
        return dto;
    }
}