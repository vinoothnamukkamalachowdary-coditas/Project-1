package com.example.L.D_Platform.Mapper;

import com.example.L.D_Platform.DTO.UserDTO;
import com.example.L.D_Platform.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserDTO user){
        User user1 = new User();
        user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());
        user.setRole(user.getRole());
        return user1;
    }
    public UserDTO toDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setRole(user.getRole());
        return userDTO;
    }
}
