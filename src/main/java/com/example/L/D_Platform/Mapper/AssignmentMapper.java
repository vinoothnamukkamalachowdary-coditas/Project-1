package com.example.L.D_Platform.Mapper;

import com.example.L.D_Platform.DTO.AssignmentDTO;
import com.example.L.D_Platform.Entity.Assignment;
import com.example.L.D_Platform.Entity.Course;
import com.example.L.D_Platform.Repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AssignmentMapper {
    private final CourseRepository repository;

    public Assignment toEntity(AssignmentDTO dto){
        Course course = repository.findById(dto.getCourseId()).orElseThrow(() -> new RuntimeException("course not found"));
        return Assignment.builder()
                .name(dto.getName())
                .details(dto.getDetails())
                .maxScore(dto.getMaxScore())
                .course(course)
                .build();
    }

    public AssignmentDTO toDTO(Assignment assignment){
        AssignmentDTO assignmentDTO = new AssignmentDTO();
        assignmentDTO.setName(assignment.getName());
        assignmentDTO.setDetails(assignment.getDetails());
        assignmentDTO.setMaxScore(assignment.getMaxScore());
        assignmentDTO.setCourseId(assignment.getCourse().getId());
        return assignmentDTO;
    }
}
