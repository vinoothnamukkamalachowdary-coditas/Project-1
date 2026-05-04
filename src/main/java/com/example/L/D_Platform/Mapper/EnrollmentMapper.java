package com.example.L.D_Platform.Mapper;

import com.example.L.D_Platform.DTO.EnrollmentDTO;
import com.example.L.D_Platform.Entity.Enrollment;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentMapper {
    public EnrollmentDTO toDTO(Enrollment e){
       EnrollmentDTO eDTO=new EnrollmentDTO();
       eDTO.setCourseId(e.getCourse().getId());
       eDTO.setUserId(e.getUser().getId());
       return eDTO;
    }
}
