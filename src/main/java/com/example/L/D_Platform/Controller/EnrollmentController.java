package com.example.L.D_Platform.Controller;

import com.example.L.D_Platform.CommonResponse.APIResponse;
import com.example.L.D_Platform.DTO.EnrollmentDTO;
import com.example.L.D_Platform.Entity.Enrollment;
import com.example.L.D_Platform.Repository.CertificateRepository;
import com.example.L.D_Platform.Repository.CourseRepository;
import com.example.L.D_Platform.Repository.EnrollmentRepository;
import com.example.L.D_Platform.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    @Autowired
    private EnrollmentRepository repo1;
    @Autowired
    private UserRepository repo2;
    @Autowired
    private CourseRepository repo3;
    @PostMapping
    public APIResponse<?> enroll(@RequestBody EnrollmentDTO enrollment){
        Enrollment e = new  Enrollment();
        e.setUser(repo2.findById(enrollment.getUserId()).orElseThrow());
        e.setCourse(repo3.findById(enrollment.getCourseId()).orElseThrow());
        e.setProgress(0);
        return new APIResponse<>(true,"Enrollment",repo1.save(e));
    }
}
