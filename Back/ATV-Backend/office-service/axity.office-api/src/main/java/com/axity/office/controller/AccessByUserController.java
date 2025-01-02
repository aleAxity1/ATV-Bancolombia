package bancolombia.controller;

import bancolombia.commons.DTO.AccessByUserDTO;
import bancolombia.facade.AccessByUserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accessbyuser")
public class AccessByUserController {

    @Autowired
    private AccessByUserFacade accessByUserFacade;

    @PostMapping
    public ResponseEntity<AccessByUserDTO> create(@RequestBody AccessByUserDTO accessByUserDTO) {
        return ResponseEntity.ok(accessByUserFacade.create(accessByUserDTO));
    }

    @GetMapping
    public ResponseEntity<List<AccessByUserDTO>> readAll() {
        return ResponseEntity.ok(accessByUserFacade.readAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccessByUserDTO> read(@PathVariable("id") int id) {
        return ResponseEntity.ok(accessByUserFacade.read(id));
    }

    @PutMapping
    public ResponseEntity<AccessByUserDTO> update(@RequestBody AccessByUserDTO accessByUserDTO) {
        return ResponseEntity.ok(accessByUserFacade.update(accessByUserDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        accessByUserFacade.delete(id);
        return ResponseEntity.ok().build();
    }
}