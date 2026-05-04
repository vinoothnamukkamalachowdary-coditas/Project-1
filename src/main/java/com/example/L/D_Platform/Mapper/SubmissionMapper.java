package com.example.L.D_Platform.Mapper;

import com.example.L.D_Platform.DTO.SubmissionDTO;
import com.example.L.D_Platform.Entity.Assignment;
import com.example.L.D_Platform.Entity.Submission;
import com.example.L.D_Platform.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class SubmissionMapper {
    public Submission toEntity(SubmissionDTO submissionDTO, User user, Assignment assignment){
        Submission submission = new Submission();
        submission.setAssignment(assignment);
        submission.setUser(user);
        return submission;
    }

    public SubmissionDTO toDTO(Submission submission){
        SubmissionDTO submissionDTO = new SubmissionDTO();
        submissionDTO.setUserId(submission.getUser().getId());
        submissionDTO.setAssignmentId(submission.getAssignment().getId());
        return submissionDTO;
    }
}
