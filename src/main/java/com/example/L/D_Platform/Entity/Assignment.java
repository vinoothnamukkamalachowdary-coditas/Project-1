package com.example.L.D_Platform.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*; // Added for validation
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Assignment name is required")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    private String name;

    @NotBlank(message = "Details cannot be empty")
    private String details;

    @Min(value = 1, message = "Max score must be at least 1")
    @Max(value = 100, message = "Max score cannot exceed 100")
    private int maxScore;

    @NotNull(message = "Assignment must be linked to a course")
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
