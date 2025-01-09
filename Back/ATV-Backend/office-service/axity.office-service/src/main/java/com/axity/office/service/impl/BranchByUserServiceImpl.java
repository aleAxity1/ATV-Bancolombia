package com.axity.office.service.impl;

import com.axity.office.commons.dto.BranchByUserDTO;
import com.axity.office.model.Branch;
import com.axity.office.model.BranchByUser;
import com.axity.office.persistence.BranchByUserRepository;
import com.axity.office.persistence.BranchRepository;
import com.axity.office.service.BranchByUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchByUserServiceImpl implements BranchByUserService {

    @Autowired
    private BranchByUserRepository branchByUserRepository;

    @Autowired
    private BranchRepository branchRepository;


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

    @Override
    public List<BranchByUserDTO> findAllByUser(String userId) {
        
        List<Branch> branches =  branchRepository.findAll();
        return branchByUserRepository.findAllByUser(userId).stream().map(branchByUser -> {
            BranchByUserDTO dto = new BranchByUserDTO();
            dto.setXsid(branchByUser.getXsid());
            dto.setXsuser(branchByUser.getXsuser());
            dto.setXscosu(branchByUser.getXscosu());
            dto.setXsnmsu(
                (branches.stream().filter(branch -> Short.parseShort(branch.getXnnmky()) == branchByUser.getXscosu())
                                 .findFirst()).get().getXnname()
            );
            return dto;
        }).collect(Collectors.toList());
    }

    public List<BranchByUserDTO> updateByUser(String userId, List<Short> branches) {
    
        List<BranchByUser> currentList = branchByUserRepository.findAllByUser(userId);
        if(!currentList.isEmpty() && currentList.size() > 0)
        {
            List<BranchByUser> objectsToRemove = currentList.stream()
                .filter(branchByUser -> !branches.contains(branchByUser.getXscosu()))
                .collect(Collectors.toList());

            objectsToRemove.forEach(branchByUser->{
                branchByUserRepository.deleteByUserAndBranch(branchByUser.getXsuser(), branchByUser.getXscosu());
            });
        }

        if(!branches.isEmpty() && branches.size() > 0)
        {
            List<BranchByUser> objectsToInsert = branches.stream()
                .filter(id -> !currentList.stream().anyMatch(b -> b.getXscosu() == id.shortValue()))
                .map(id -> {
                    BranchByUser newEntity = new BranchByUser();
                    newEntity.setXscosu(id);
                    newEntity.setXsuser(userId);
                    return newEntity;
                })
                .collect(Collectors.toList());

            objectsToInsert.forEach(branchByUser->{
                branchByUserRepository.save(branchByUser);
            });
        }
        return findAllByUser(userId);
    }
}