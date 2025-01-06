package com.axity.office.controller;

import com.axity.office.commons.dto.UserDTO;
import com.axity.office.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userFacade.createUser(userDTO));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userFacade.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(userFacade.getUserById(id));
    }

    @GetMapping("/test/{id}")
    public ResponseEntity<String> getUserTestById(@PathVariable String id, Authentication authentication) {
        JwtAuthenticationToken jwtToken = (JwtAuthenticationToken) authentication;
        String preferredUsername = jwtToken.getToken().getClaimAsString("preferred_username");
        return ResponseEntity.ok("Hola " + preferredUsername + " con id: " + id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String id, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userFacade.updateUser(id, userDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userFacade.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}