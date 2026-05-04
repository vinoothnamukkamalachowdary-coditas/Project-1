package com.example.L.D_Platform.Controller;

import com.example.L.D_Platform.CommonResponse.APIResponse;
import com.example.L.D_Platform.DTO.EnrollmentDTO;
import com.example.L.D_Platform.Entity.Enrollment;
import com.example.L.D_Platform.Repository.CertificateRepository;
import com.example.L.D_Platform.Repository.CourseRepository;
import com.example.L.D_Platform.Repository.EnrollmentRepository;
import com.example.L.D_Platform.Repository.UserRepository;
import com.example.L.D_Platform.Service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    @Autowired
    private EnrollmentService service;

    @PostMapping
    public APIResponse<Enrollment> enrollment(@RequestBody EnrollmentDTO enroll) {
        return new APIResponse<>(true,"Enrolled",service.enrollment(enroll));
    }

    @GetMapping("/user/{id}")
    public APIResponse<List<Enrollment>> getEnrollment(@PathVariable Long id) {
        return new APIResponse<>(true,"List of Enrolled users",service.getEnrollment(id));
    }

    @PutMapping("/{id}/progress")
    public APIResponse<?> updateProgress(@PathVariable Long id, @RequestParam int progress) {
        service.updateProgress(id,progress);
        return new APIResponse<>(true,"Enrolled",null);
    }
}
