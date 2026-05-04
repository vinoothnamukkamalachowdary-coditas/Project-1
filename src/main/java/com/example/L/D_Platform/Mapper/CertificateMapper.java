package com.example.L.D_Platform.Mapper;

import com.example.L.D_Platform.Entity.Certificate;
import com.example.L.D_Platform.Entity.Course;
import com.example.L.D_Platform.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class CertificateMapper {
    public Certificate toEntity(User user, Course course){
        Certificate certificate=new Certificate();
        certificate.setUser(user);
        certificate.setCourse(course);
        certificate.setName(course.getTitle() + "Certified");
        return certificate;
    }
}
