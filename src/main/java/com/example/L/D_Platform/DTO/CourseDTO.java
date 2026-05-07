package com.example.L.D_Platform.DTO;

import lombok.Data;

import java.util.List;

@Data
public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    private int duration;
    private List<ModuleDTO> modules;
}
