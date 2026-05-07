package com.example.L.D_Platform.Mapper;

import com.example.L.D_Platform.DTO.CourseDTO;
import com.example.L.D_Platform.DTO.ModuleDTO;
import com.example.L.D_Platform.Entity.Course;
import com.example.L.D_Platform.Entity.Module;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CourseMapper {

    private final ModuleMapper moduleMapper;

    public Course toEntity(CourseDTO dto) {

        if (dto == null) {
            return null;
        }

        Course course = new Course();

        course.setId(dto.getId());
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setDuration(dto.getDuration());

        return course;
    }

    public CourseDTO toDTO(Course course) {

        if (course == null) {
            return null;
        }

        CourseDTO dto = new CourseDTO();

        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        dto.setDuration(course.getDuration());

        // Recursion-safe module mapping
        if (course.getModules() != null) {

            List<ModuleDTO> moduleDTOs =
                    course.getModules()
                            .stream()
                            .map(moduleMapper::toDTO)
                            .toList();

            dto.setModules(moduleDTOs);
        }

        return dto;
    }

    // Partial update support
    public void updateEntity(Course course, CourseDTO dto) {

        if (dto.getTitle() != null) {
            course.setTitle(dto.getTitle());
        }

        if (dto.getDescription() != null) {
            course.setDescription(dto.getDescription());
        }

        if (dto.getDuration() > 0) {
            course.setDuration(dto.getDuration());
        }
    }
}
