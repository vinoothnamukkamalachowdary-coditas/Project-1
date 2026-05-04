package com.example.L.D_Platform.Service;

import com.example.L.D_Platform.DTO.EnrollmentDTO;
import com.example.L.D_Platform.Entity.Course;
import com.example.L.D_Platform.Entity.Enrollment;
import com.example.L.D_Platform.Entity.User;
import com.example.L.D_Platform.Exception.ResourceNotFound;
import com.example.L.D_Platform.Repository.EnrollmentRepository;
import com.example.L.D_Platform.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseService service;

    public Enrollment enrollment(EnrollmentDTO enroll) {
        User user = userRepository.findById(enroll.getUserId()).get();
        Course c = service.getById(enroll.getCourseId());
        Enrollment enrollment = new Enrollment();
        enrollment.setUser(user);
        enrollment.setCourse(c);
        enrollment.setProgress(0);
        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getEnrollment(Long id) {
        return enrollmentRepository.findByUserId(id);
    }

    public void updateProgress(Long id, int progress) {
        Enrollment enrollment = enrollmentRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Enrollment Not Found"));
        enrollment.setProgress(progress);
        enrollmentRepository.save(enrollment);
    }
}
