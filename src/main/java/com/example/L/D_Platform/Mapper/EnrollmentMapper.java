package com.example.L.D_Platform.Mapper;

import com.example.L.D_Platform.DTO.EnrollmentDTO;
import com.example.L.D_Platform.Entity.Enrollment;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentMapper {

    public EnrollmentDTO toDTO(Enrollment e) {
        EnrollmentDTO dto = new EnrollmentDTO();
        dto.setId(e.getId());
        dto.setUserId(e.getUser().getId());
        dto.setCourseId(e.getCourse().getId());
        dto.setProgress(e.getProgress());
        dto.setStatus(e.getStatus());
        dto.setCertified(e.isCertified());
        dto.setUserName(e.getUser().getName());
        dto.setCourseTitle(e.getCourse().getTitle());
        return dto;
    }
}