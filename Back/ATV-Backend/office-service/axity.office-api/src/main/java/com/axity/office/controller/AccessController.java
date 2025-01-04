package com.axity.office.controller;

import com.axity.office.commons.dto.AccessDTO;
import com.axity.office.facade.AccessFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/access")
public class AccessController {

    @Autowired
    private AccessFacade accessFacade;

    @PostMapping
    public ResponseEntity<AccessDTO> create(@RequestBody AccessDTO accessDTO) {
        return ResponseEntity.ok(accessFacade.create(accessDTO));
    }

    @GetMapping
    public ResponseEntity<List<AccessDTO>> readAll() {
        return ResponseEntity.ok(accessFacade.readAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccessDTO> read(@PathVariable("id") int id) {
        return ResponseEntity.ok(accessFacade.read(id));
    }

    @PutMapping
    public ResponseEntity<AccessDTO> update(@RequestBody AccessDTO accessDTO) {
        return ResponseEntity.ok(accessFacade.update(accessDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        accessFacade.delete(id);
        return ResponseEntity.ok().build();
    }
}