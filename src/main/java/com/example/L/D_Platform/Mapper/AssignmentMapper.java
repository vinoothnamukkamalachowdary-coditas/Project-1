package com.example.L.D_Platform.Mapper;

import com.example.L.D_Platform.DTO.AssignmentDTO;
import com.example.L.D_Platform.Entity.Assignment;
import com.example.L.D_Platform.Entity.Course;
import org.springframework.stereotype.Component;

@Component
public class AssignmentMapper {
    public Assignment toEntity(AssignmentDTO dto, Course course){
        Assignment assignment = new Assignment();
        assignment.setName(dto.getName());
        assignment.setDetails(dto.getDetails());
        assignment.setMaxScore(dto.getMaxScore());
        assignment.setCourse(course);
        return assignment;
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
