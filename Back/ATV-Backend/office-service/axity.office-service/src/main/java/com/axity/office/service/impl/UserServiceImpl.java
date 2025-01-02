package com.axity.office.service.impl;

import com.axity.office.commons.dto.UserDTO;
import com.axity.office.model.User;
import com.axity.office.persistence.UserRepository;
import com.axity.office.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setXuuser(userDTO.getXuuser());
        user.setXuname(userDTO.getXuname());
        user.setXucarg(userDTO.getXucarg());
        user.setXuacce(userDTO.getXuacce());
        user.setXudom(userDTO.getXudom());
        user.setXuusrt(userDTO.getXuusrt());
        userRepository.save(user);
        return userDTO;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(user -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setXuuser(user.getXuuser());
            userDTO.setXuname(user.getXuname());
            userDTO.setXucarg(user.getXucarg());
            userDTO.setXuacce(user.getXuacce());
            userDTO.setXudom(user.getXudom());
            userDTO.setXuusrt(user.getXuusrt());
            return userDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(String id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) return null;
        UserDTO userDTO = new UserDTO();
        userDTO.setXuuser(user.getXuuser());
        userDTO.setXuname(user.getXuname());
        userDTO.setXucarg(user.getXucarg());
        userDTO.setXuacce(user.getXuacce());
        userDTO.setXudom(user.getXudom());
        userDTO.setXuusrt(user.getXuusrt());
        return userDTO;
    }

    @Override
    public UserDTO updateUser(String id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) return null;
        user.setXuname(userDTO.getXuname());
        user.setXucarg(userDTO.getXucarg());
        user.setXuacce(userDTO.getXuacce());
        user.setXudom(userDTO.getXudom());
        user.setXuusrt(userDTO.getXuusrt());
        userRepository.save(user);
        return userDTO;
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}