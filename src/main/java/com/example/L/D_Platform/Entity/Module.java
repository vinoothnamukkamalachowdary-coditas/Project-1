package com.example.L.D_Platform.Entity;

import com.example.L.D_Platform.Entity.Course;
import com.example.L.D_Platform.Entity.ModuleProgress;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank; // Imported for validation
import jakarta.validation.constraints.NotNull;  // Imported for validation
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Module name cannot be blank") // Validation
    private String name;

    private String link;

    @ManyToOne(fetch = FetchType.LAZY) // Optimized fetch
    @JoinColumn(name = "course_id", nullable = false) // FK constraint in DB
    @NotNull(message = "Module must belong to a course") // Validation
    private Course course;

    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL)
    private List<ModuleProgress> moduleProgress;
}
