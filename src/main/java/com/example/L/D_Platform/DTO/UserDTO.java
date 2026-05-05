package com.example.L.D_Platform.DTO;

import com.example.L.D_Platform.Entity.Role;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String username;
    private String password;
    private Role role;
    private String email;
    private boolean onBench;
}
