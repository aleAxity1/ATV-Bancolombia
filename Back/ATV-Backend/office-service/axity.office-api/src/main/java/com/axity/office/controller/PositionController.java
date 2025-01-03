package com.axity.office.controller;

import com.axity.office.commons.dto.PositionDTO;
import com.axity.office.facade.PositionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionController {

    @Autowired
    private PositionFacade positionFacade;

    @PostMapping
    public ResponseEntity<PositionDTO> createPosition(@RequestBody PositionDTO positionDTO) {
        return ResponseEntity.ok(positionFacade.createPosition(positionDTO));
    }

    @GetMapping
    public ResponseEntity<List<PositionDTO>> getAllPositions() {
        return ResponseEntity.ok(positionFacade.getAllPositions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PositionDTO> getPositionById(@PathVariable String id) {
        return ResponseEntity.ok(positionFacade.getPositionById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PositionDTO> updatePosition(@PathVariable String id, @RequestBody PositionDTO positionDTO) {
        return ResponseEntity.ok(positionFacade.updatePosition(id, positionDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePosition(@PathVariable String id) {
        positionFacade.deletePosition(id);
        return ResponseEntity.noContent().build();
    }
}