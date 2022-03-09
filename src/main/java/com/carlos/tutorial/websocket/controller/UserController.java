package com.carlos.tutorial.websocket.controller;

import com.carlos.tutorial.websocket.dto.UserDTO;
import com.carlos.tutorial.websocket.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.listAll();
    }

    @MessageMapping
//    @SendTo("/topic/user")
    public UserDTO save(@Payload String dto) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        UserDTO userConvert = objectMapper.readValue(dto, UserDTO.class);
        UserDTO userDTO = userService.save(userConvert);
        this.simpMessagingTemplate.convertAndSend("/topic/user", userDTO.getName());
        return userDTO;
    }



}
