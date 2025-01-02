package bancolombia.facade.impl;

import bancolombia.commons.DTO.PositionDTO;
import bancolombia.facade.PositionFacade;
import bancolombia.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PositionFacadeImpl implements PositionFacade {

    @Autowired
    private PositionService positionService;

    @Override
    public PositionDTO createPosition(PositionDTO positionDTO) {
        return positionService.createPosition(positionDTO);
    }

    @Override
    public List<PositionDTO> getAllPositions() {
        return positionService.getAllPositions();
    }

    @Override
    public PositionDTO getPositionById(String id) {
        return positionService.getPositionById(id);
    }

    @Override
    public PositionDTO updatePosition(String id, PositionDTO positionDTO) {
        return positionService.updatePosition(id, positionDTO);
    }

    @Override
    public void deletePosition(String id) {
        positionService.deletePosition(id);
    }
}