package com.example.L.D_Platform.Mapper;

import com.example.L.D_Platform.DTO.SubmissionDTO;
import com.example.L.D_Platform.Entity.Assignment;
import com.example.L.D_Platform.Entity.Submission;
import com.example.L.D_Platform.Entity.User;
import com.example.L.D_Platform.Repository.AssignmentRepository;
import com.example.L.D_Platform.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubmissionMapper {

    private final AssignmentRepository assignmentRepository;
    private final UserRepository userRepository;

    public Submission toEntity(SubmissionDTO dto) {

        Assignment assignment = assignmentRepository.findById(dto.getAssignmentId())
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return Submission.builder()
                .assignment(assignment)
                .user(user)
                .score(dto.getScore())
                .status(dto.getStatus())
                .response(dto.getResponse())
                .build();
    }

    public SubmissionDTO toDTO(Submission entity) {
        SubmissionDTO dto = new SubmissionDTO();
        dto.setAssignmentId(entity.getAssignment().getId());
        dto.setUserId(entity.getUser().getId());
        dto.setScore(entity.getScore());
        dto.setStatus(entity.getStatus());
        dto.setResponse(entity.getResponse());
        return dto;
    }
}
