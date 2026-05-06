package com.example.L.D_Platform.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JsonBackReference
    private User user;

    @ManyToOne
    private Course course;

    private int progress; // %

    @Enumerated(EnumType.STRING)
    private Status status;

    private boolean certified;
}