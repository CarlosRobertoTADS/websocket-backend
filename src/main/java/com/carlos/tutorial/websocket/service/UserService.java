package com.carlos.tutorial.websocket.service;

import com.carlos.tutorial.websocket.domain.User;
import com.carlos.tutorial.websocket.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserDTO> listAll();
    UserDTO save(UserDTO userDTO);
}
