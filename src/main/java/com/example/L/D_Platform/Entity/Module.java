package com.example.L.D_Platform.Entity;

import com.example.L.D_Platform.Entity.Course;
import com.example.L.D_Platform.Entity.ModuleProgress;
import jakarta.persistence.*;
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
    @GeneratedValue
    private Long id;

    private String name;
    private String link;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "module",cascade = CascadeType.ALL)
    private List<ModuleProgress> moduleProgress;


}