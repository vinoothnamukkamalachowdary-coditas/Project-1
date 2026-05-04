package com.example.L.D_Platform.Service;

import com.example.L.D_Platform.DTO.CourseDTO;
import com.example.L.D_Platform.Entity.Course;
import com.example.L.D_Platform.Mapper.CourseMapper;
import com.example.L.D_Platform.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseMapper courseMapper;
    public CourseDTO addCourse(CourseDTO course) {
        return courseMapper.toDTO(courseRepository.save(courseMapper.toEntity(course)));
    }

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream().map(courseMapper::toDTO).toList();
    }

    public Course getById(Long courseId) {
        return courseRepository.findById(courseId).get();
    }
}
