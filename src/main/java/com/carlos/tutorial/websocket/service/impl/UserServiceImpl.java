package com.carlos.tutorial.websocket.service.impl;

import com.carlos.tutorial.websocket.domain.User;
import com.carlos.tutorial.websocket.dto.UserDTO;
import com.carlos.tutorial.websocket.mapper.UserMapper;
import com.carlos.tutorial.websocket.repository.UserRepository;
import com.carlos.tutorial.websocket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> listAll() {
        List<UserDTO> users = new ArrayList<>();
        userRepository.findAll().forEach(user ->
                users.add(new UserMapper().convertDTO(user)));
        return users;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        return new UserMapper().convertDTO(userRepository.save(new UserMapper().convertEntity(userDTO)));
    }

}
