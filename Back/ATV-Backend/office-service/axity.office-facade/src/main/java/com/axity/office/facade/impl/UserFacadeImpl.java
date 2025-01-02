package bancolombia.facade.impl;

import bancolombia.commons.DTO.UserDTO;
import bancolombia.facade.UserFacade;
import bancolombia.service.UserService;
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