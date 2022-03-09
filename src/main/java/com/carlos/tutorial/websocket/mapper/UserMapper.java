package com.carlos.tutorial.websocket.mapper;

import com.carlos.tutorial.websocket.domain.User;
import com.carlos.tutorial.websocket.dto.UserDTO;

public class UserMapper {

    public User convertEntity(UserDTO dto){
        return  User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
    }

    public UserDTO convertDTO(User entity){
        return  UserDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
    }

}
