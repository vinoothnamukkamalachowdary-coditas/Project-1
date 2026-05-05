package com.example.L.D_Platform.Entity;

import com.example.L.D_Platform.Entity.Course;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Assignment {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;

    @OneToOne
    private Course course;
}