package com.example.L.D_Platform.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModuleProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Typically primitive booleans default to false,
    // but @NotNull ensures the wrapper Boolean isn't null if you change types later.
    @NotNull(message = "Completion status must be specified")
    private boolean completed = false;

    @NotNull(message = "Module is required")
    @ManyToOne(fetch = FetchType.LAZY) // Lazy loading is better for performance
    @JoinColumn(name = "module_id")
    private Module module;

    @NotNull(message = "User is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
