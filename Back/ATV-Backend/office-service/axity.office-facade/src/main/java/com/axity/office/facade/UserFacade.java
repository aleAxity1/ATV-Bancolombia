package com.axity.office.facade;

import com.axity.office.commons.dto.UserDTO;

import java.util.List;

public interface UserFacade {
    UserDTO createUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(String id);
    UserDTO updateUser(String id, UserDTO userDTO);
    void deleteUser(String id);
}