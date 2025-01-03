package com.axity.office.service;


import java.util.List;

import com.axity.office.commons.dto.UserDTO;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(String id);
    UserDTO updateUser(String id, UserDTO userDTO);
    void deleteUser(String id);
}