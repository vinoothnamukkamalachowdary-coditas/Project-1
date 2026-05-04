package com.example.L.D_Platform.Controller;

import com.example.L.D_Platform.CommonResponse.APIResponse;
import com.example.L.D_Platform.DTO.LoginDTO;
import com.example.L.D_Platform.DTO.LoginResponseDTO;
import com.example.L.D_Platform.Entity.User;
import com.example.L.D_Platform.Exception.ResourceNotFound;
import com.example.L.D_Platform.Repository.UserRepository;
import com.example.L.D_Platform.Util.JwtUtil;
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
    private UserRepository repo;
    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/register")
    public APIResponse<?> register(@RequestBody User user){
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return new APIResponse<>(true,"Registered",null);
    }
    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginDTO dto){
        User user = repo.findByUsername(dto.getUsername()).orElseThrow(() -> new ResourceNotFound("User is not Found"));
        if(encoder.matches(dto.getPassword(),user.getPassword())){
            throw new RuntimeException("Wrong Password");
        }
        return new LoginResponseDTO(jwtUtil.generateToken(user.getUsername()));
    }
}
