package com.acr.demorest.service;

import com.acr.demorest.dto.UserDTO;
import com.acr.demorest.entity.User;
import com.acr.demorest.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    //Convert UserDTO to User mapper
    public User convertToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    //Save user but accept argument as UserDTO and return UserDTO
    public UserDTO saveUser(UserDTO userDTO) {
        User user = convertToUser(userDTO);
        userDAO.save(user);
        return userDTO;
    }

    //Convert User to UserDTO mapper
    public UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    //Get all users and convert to UserDTO
    public List<UserDTO> getAllUsers() {
        List<User> users = userDAO.findAll();
        return users.stream().map(this::convertToUserDTO).collect(Collectors.toList());
    }

    //Get user by id
    public Optional<User> getUserById(int id) {
        return userDAO.findById(id);
    }

    //Update user by id





}
