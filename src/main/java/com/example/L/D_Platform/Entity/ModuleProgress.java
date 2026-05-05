package com.example.L.D_Platform.Entity;

import jakarta.persistence.*;
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
    private int id;
    private int completedModules;
    private int to_Complete;
    private int totalModules;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;
}
