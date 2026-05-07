package com.example.L.D_Platform.Controller;

import com.example.L.D_Platform.CommonResponse.APIResponse;
import com.example.L.D_Platform.DTO.LoginDTO;
import com.example.L.D_Platform.DTO.LoginResponseDTO;
import com.example.L.D_Platform.DTO.UserDTO;
import com.example.L.D_Platform.Entity.User;
import com.example.L.D_Platform.Exception.ResourceNotFound;
import com.example.L.D_Platform.Repository.UserRepository;
import com.example.L.D_Platform.Service.AuthService;
import com.example.L.D_Platform.Util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthService service;
    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/register")
    public APIResponse<?> register(@Valid @RequestBody UserDTO user){
        return new APIResponse<>(true,"Registered",service.register(user));
    }
    @PostMapping("/login")
    public LoginResponseDTO login(@Valid @RequestBody LoginDTO dto){

        User user = service.findByUsername(dto.getUsername());

        if (!encoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtUtil.generateToken(user.getEmail(),user.getRole().name());

        return new LoginResponseDTO(token);
    }

}
