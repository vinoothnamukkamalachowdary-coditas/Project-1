package com.example.L.D_Platform.Service;

import com.example.L.D_Platform.Config.JwtFilter;
import com.example.L.D_Platform.DTO.UserDTO;
import com.example.L.D_Platform.Entity.User;
import com.example.L.D_Platform.Mapper.UserMapper;
import com.example.L.D_Platform.Repository.UserRepository;
import com.example.L.D_Platform.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    public UserDTO register(UserDTO dto) {

        User user = new User();
        user.setName(dto.getName());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setRole(dto.getRole());
        user.setOnBench(dto.isOnBench());

        user.setPassword(encoder.encode(dto.getPassword()));

        userRepository.save(user);

        return dto;
    }
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

}


