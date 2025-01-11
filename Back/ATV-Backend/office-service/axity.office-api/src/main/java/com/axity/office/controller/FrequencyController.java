package com.axity.office.controller;

import com.axity.office.commons.dto.FrequencyDto;
import com.axity.office.commons.request.PaginatedRequestDto;
import com.axity.office.facade.FrequencyFacade;
import com.axity.office.commons.response.GenericResponseDto;
import com.axity.office.commons.response.PaginatedResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/frequencies")
public class FrequencyController {

    @Autowired
    private FrequencyFacade frequencyFacade;

    @GetMapping("")
    public ResponseEntity<PaginatedResponseDto<FrequencyDto>> findFrequencies(
            @RequestParam(defaultValue = "50") int limit,
            @RequestParam(defaultValue = "0") int offset) {
        return ResponseEntity.ok(this.frequencyFacade.findFrequencies(new PaginatedRequestDto(limit, offset)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponseDto<FrequencyDto>> findFrequency(@PathVariable Long id) {
        var result = this.frequencyFacade.find(id);
        return new ResponseEntity<>(result, result == null ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @GetMapping("/{productId}/{documentId}")
    public ResponseEntity<GenericResponseDto<FrequencyDto>> findFrequencyByProductDocument(@PathVariable String productId, @PathVariable String documentId) {
        var result = this.frequencyFacade.findByProductDocument(productId, documentId);
        return new ResponseEntity<>(result, result == null ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<GenericResponseDto<FrequencyDto>> create(@RequestBody FrequencyDto dto) {
        return new ResponseEntity<>(this.frequencyFacade.create(dto), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<GenericResponseDto<Boolean>> update(@RequestBody FrequencyDto dto) {
        return ResponseEntity.ok(this.frequencyFacade.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponseDto<Boolean>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(this.frequencyFacade.delete(id));
    }

    @GetMapping("ping")
    public ResponseEntity<GenericResponseDto<String>> ping() {
        return ResponseEntity.ok(new GenericResponseDto<>("pong"));
    }
}