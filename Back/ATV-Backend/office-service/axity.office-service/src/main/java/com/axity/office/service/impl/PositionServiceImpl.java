package com.axity.office.service.impl;

import com.axity.office.commons.dto.PositionDTO;
import com.axity.office.model.Position;
import com.axity.office.persistence.PositionRepository;
import com.axity.office.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public PositionDTO createPosition(PositionDTO positionDTO) {
        Position position = new Position();
        // Map DTO to Entity
        position.setXfapcd(positionDTO.getXfapcd());
        position.setXfldnm(positionDTO.getXfldnm());
        position.setXrelfl(positionDTO.getXrelfl());
        position.setXfmlcd(positionDTO.getXfmlcd());
        position.setXfencd(positionDTO.getXfencd());
        position.setXfdft(positionDTO.getXfdft());
        position.setXfdesc(positionDTO.getXfdesc());
        position.setXfleng(positionDTO.getXfleng());
        position.setXfblnk(positionDTO.getXfblnk());
        position.setXfsuse(positionDTO.getXfsuse());
        position.setXfcore(positionDTO.getXfcore());
        position.setXfendt(positionDTO.getXfendt());
        position.setXfentm(positionDTO.getXfentm());
        position.setXfsedt(positionDTO.getXfsedt());
        position.setXfenus(positionDTO.getXfenus());
        position.setXfenws(positionDTO.getXfenws());
        position.setXfdtlm(positionDTO.getXfdtlm());
        position.setXfsdtm(positionDTO.getXfsdtm());

        position = positionRepository.save(position);

        // Map Entity to DTO
        positionDTO.setXfapcd(position.getXfapcd());
        return positionDTO;
    }

    @Override
    public List<PositionDTO> getAllPositions() {
        return positionRepository.findAll().stream().map(position -> {
            PositionDTO dto = new PositionDTO();
            dto.setXfapcd(position.getXfapcd());
            dto.setXfldnm(position.getXfldnm());
            dto.setXrelfl(position.getXrelfl());
            dto.setXfmlcd(position.getXfmlcd());
            dto.setXfencd(position.getXfencd());
            dto.setXfdft(position.getXfdft());
            dto.setXfdesc(position.getXfdesc());
            dto.setXfleng(position.getXfleng());
            dto.setXfblnk(position.getXfblnk());
            dto.setXfsuse(position.getXfsuse());
            dto.setXfcore(position.getXfcore());
            dto.setXfendt(position.getXfendt());
            dto.setXfentm(position.getXfentm());
            dto.setXfsedt(position.getXfsedt());
            dto.setXfenus(position.getXfenus());
            dto.setXfenws(position.getXfenws());
            dto.setXfdtlm(position.getXfdtlm());
            dto.setXfsdtm(position.getXfsdtm());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public PositionDTO getPositionById(String id) {
        Position position = positionRepository.findById(id).orElseThrow(() -> new RuntimeException("Position not found"));
        PositionDTO dto = new PositionDTO();
        dto.setXfapcd(position.getXfapcd());
        dto.setXfldnm(position.getXfldnm());
        dto.setXrelfl(position.getXrelfl());
        dto.setXfmlcd(position.getXfmlcd());
        dto.setXfencd(position.getXfencd());
        dto.setXfdft(position.getXfdft());
        dto.setXfdesc(position.getXfdesc());
        dto.setXfleng(position.getXfleng());
        dto.setXfblnk(position.getXfblnk());
        dto.setXfsuse(position.getXfsuse());
        dto.setXfcore(position.getXfcore());
        dto.setXfendt(position.getXfendt());
        dto.setXfentm(position.getXfentm());
        dto.setXfsedt(position.getXfsedt());
        dto.setXfenus(position.getXfenus());
        dto.setXfenws(position.getXfenws());
        dto.setXfdtlm(position.getXfdtlm());
        dto.setXfsdtm(position.getXfsdtm());
        return dto;
    }

    @Override
    public PositionDTO updatePosition(String id, PositionDTO positionDTO) {
        Position position = positionRepository.findById(id).orElseThrow(() -> new RuntimeException("Position not found"));
        // Update fields
        position.setXfldnm(positionDTO.getXfldnm());
        position.setXrelfl(positionDTO.getXrelfl());
        position.setXfmlcd(positionDTO.getXfmlcd());
        position.setXfencd(positionDTO.getXfencd());
        position.setXfdft(positionDTO.getXfdft());
        position.setXfdesc(positionDTO.getXfdesc());
        position.setXfleng(positionDTO.getXfleng());
        position.setXfblnk(positionDTO.getXfblnk());
        position.setXfsuse(positionDTO.getXfsuse());
        position.setXfcore(positionDTO.getXfcore());
        position.setXfendt(positionDTO.getXfendt());
        position.setXfentm(positionDTO.getXfentm());
        position.setXfsedt(positionDTO.getXfsedt());
        position.setXfenus(positionDTO.getXfenus());
        position.setXfenws(positionDTO.getXfenws());
        position.setXfdtlm(positionDTO.getXfdtlm());
        position.setXfsdtm(positionDTO.getXfsdtm());

        position = positionRepository.save(position);

        // Map Entity to DTO
        positionDTO.setXfapcd(position.getXfapcd());
        return positionDTO;
    }

    @Override
    public void deletePosition(String id) {
        positionRepository.deleteById(id);
    }
}