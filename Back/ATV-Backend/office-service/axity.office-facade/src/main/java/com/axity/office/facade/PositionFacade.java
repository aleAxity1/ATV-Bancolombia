package bancolombia.facade;

import bancolombia.commons.DTO.PositionDTO;

import java.util.List;

public interface PositionFacade {
    PositionDTO createPosition(PositionDTO positionDTO);
    List<PositionDTO> getAllPositions();
    PositionDTO getPositionById(String id);
    PositionDTO updatePosition(String id, PositionDTO positionDTO);
    void deletePosition(String id);
}