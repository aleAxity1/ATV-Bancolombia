package com.axity.office.service.impl;

import com.axity.office.commons.dto.BranchByUserDTO;
import com.axity.office.model.BranchByUser;
import com.axity.office.persistence.BranchByUserRepository;
import com.axity.office.service.BranchByUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchByUserServiceImpl implements BranchByUserService {

    @Autowired
    private BranchByUserRepository branchByUserRepository;

    @Override
    public BranchByUserDTO create(BranchByUserDTO branchByUserDTO) {
        BranchByUser branchByUser = new BranchByUser();
        branchByUser.setXsuser(branchByUserDTO.getXsuser());
        branchByUser.setXscosu(branchByUserDTO.getXscosu());
        branchByUserRepository.save(branchByUser);
        return branchByUserDTO;
    }

    @Override
    public List<BranchByUserDTO> readAll() {
        return branchByUserRepository.findAll().stream().map(branchByUser -> {
            BranchByUserDTO dto = new BranchByUserDTO();
            dto.setXsuser(branchByUser.getXsuser());
            dto.setXscosu(branchByUser.getXscosu());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public BranchByUserDTO read(Long id) {
        BranchByUser branchByUser = branchByUserRepository.findById(id).orElse(null);
        if (branchByUser == null) return null;
        BranchByUserDTO dto = new BranchByUserDTO();
        dto.setXsid(branchByUser.getXsid());
        dto.setXsuser(branchByUser.getXsuser());
        dto.setXscosu(branchByUser.getXscosu());
        return dto;
    }

    @Override
    public BranchByUserDTO update(BranchByUserDTO branchByUserDTO) {
        BranchByUser branchByUser = branchByUserRepository.findById(branchByUserDTO.getXsid()).orElse(null);
        if (branchByUser == null) return null;
        branchByUser.setXsuser(branchByUserDTO.getXsuser());
        branchByUser.setXscosu(branchByUserDTO.getXscosu());
        branchByUserRepository.save(branchByUser);
        return branchByUserDTO;
    }

    @Override
    public void delete(Long id) {
        branchByUserRepository.deleteById(id);
    }
}