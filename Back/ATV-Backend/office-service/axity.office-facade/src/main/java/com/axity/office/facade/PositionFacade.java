package com.axity.office.facade;

import com.axity.office.commons.dto.PositionDTO;

import java.util.List;

public interface PositionFacade {
    PositionDTO createPosition(PositionDTO positionDTO);
    List<PositionDTO> getAllPositions();
    PositionDTO getPositionById(String id);
    PositionDTO updatePosition(String id, PositionDTO positionDTO);
    void deletePosition(String id);
}