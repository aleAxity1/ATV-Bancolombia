package com.axity.office.facade.impl;

import com.axity.office.commons.dto.UserDTO;
import com.axity.office.facade.UserFacade;
import com.axity.office.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserService userService;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public UserDTO getUserById(String id) {
        return userService.getUserById(id);
    }

    @Override
    public UserDTO updateUser(String id, UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @Override
    public void deleteUser(String id) {
        userService.deleteUser(id);
    }
}