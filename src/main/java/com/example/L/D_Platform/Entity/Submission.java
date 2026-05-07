package com.example.L.D_Platform.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 0, message = "Score cannot be negative")
    @Max(value = 100, message = "Score cannot exceed 100")
    private int score;

    @NotBlank(message = "Status is required")
    private String status;

    @NotBlank(message = "Response content cannot be empty")
    private String response;

    @NotNull(message = "Assignment reference is required")
    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    @NotNull(message = "User reference is required")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
