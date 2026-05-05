package com.example.L.D_Platform.Mapper;

import com.example.L.D_Platform.DTO.CourseDTO;
import com.example.L.D_Platform.Entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public Course toEntity(CourseDTO dto){
        Course course = new Course();
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setDuration(dto.getDuration());
        return course;
    }
    public CourseDTO toDTO(Course c){
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(c.getId());
        courseDTO.setTitle(c.getTitle());
        courseDTO.setDescription(c.getDescription());
        courseDTO.setDuration(c.getDuration());
        return courseDTO;
    }
}
