package com.example.L.D_Platform.DTO;

import lombok.Data;

@Data
public class SubmissionDTO {
    private Long assignmentId;
    private Long userId;
    private int score;
    private String status;
    private String response;
}
