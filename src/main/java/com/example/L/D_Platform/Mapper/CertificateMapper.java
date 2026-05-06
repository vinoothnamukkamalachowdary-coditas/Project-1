package com.example.L.D_Platform.Mapper;

import com.example.L.D_Platform.DTO.CertificateDTO;
import com.example.L.D_Platform.Entity.Certificate;
import com.example.L.D_Platform.Entity.Course;
import com.example.L.D_Platform.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class CertificateMapper {
    public Certificate toEntity(CertificateDTO dto, User user, Course course) {
        Certificate cert = new Certificate();
        cert.setId(dto.getId());
        cert.setUser(user);
        cert.setCourse(course);
        cert.setName(dto.getName());
        return cert;
    }


    public CertificateDTO toDTO(Certificate cert) {
        CertificateDTO dto = new CertificateDTO();
        dto.setId(cert.getId());
        dto.setUserId(cert.getUser().getId());
        dto.setCourseId(cert.getCourse().getId());
        dto.setName(cert.getName());
        return dto;
    }

}
