package com.example.L.D_Platform.DTO;

import lombok.Data;

@Data
public class ModuleProgressDTO {
    private Long id;
    private Long userId;
    private Long moduleId;
    private boolean completed;
}
