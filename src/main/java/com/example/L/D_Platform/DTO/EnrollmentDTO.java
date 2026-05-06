package com.example.L.D_Platform.DTO;

import com.example.L.D_Platform.Entity.Status;
import lombok.Data;

@Data
public class EnrollmentDTO {
    // Request fields
    private Long userId;
    private Long courseId;

    // Response fields
    private Long id;
    private int progress;
    private Status status;
    private boolean certified;
    private String userName;
    private String courseTitle;
}