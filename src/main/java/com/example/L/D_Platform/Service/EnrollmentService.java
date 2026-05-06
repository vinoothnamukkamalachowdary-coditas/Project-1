package com.example.L.D_Platform.Service;

import com.example.L.D_Platform.DTO.EnrollmentDTO;
import com.example.L.D_Platform.Entity.Course;
import com.example.L.D_Platform.Entity.Enrollment;
import com.example.L.D_Platform.Entity.User;
import com.example.L.D_Platform.Exception.ResourceNotFound;
import com.example.L.D_Platform.Mapper.EnrollmentMapper;
import com.example.L.D_Platform.Repository.EnrollmentRepository;
import com.example.L.D_Platform.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final CourseService courseService;
    private final EnrollmentMapper enrollmentMapper;

    // POST /api/enrollments
    public EnrollmentDTO enrollment(EnrollmentDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFound("User not found: " + dto.getUserId()));

        Course course = courseService.getById(dto.getCourseId());

        Enrollment enrollment = new Enrollment();
        enrollment.setUser(user);
        enrollment.setCourse(course);
        enrollment.setProgress(0);
        enrollment.setCertified(false);

        return enrollmentMapper.toDTO(enrollmentRepository.save(enrollment));
    }

    // GET /api/enrollments/user/{id}
    public List<EnrollmentDTO> getEnrollment(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFound("User not found: " + userId));

        return enrollmentRepository.findByUserId(userId)
                .stream()
                .map(enrollmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    // PUT /api/enrollments/{id}/progress
    public EnrollmentDTO updateProgress(Long enrollmentId, int progress) {
        if (progress < 0 || progress > 100) {
            throw new IllegalArgumentException("Progress must be between 0 and 100");
        }
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new ResourceNotFound("Enrollment not found: " + enrollmentId));

        enrollment.setProgress(progress);
        return enrollmentMapper.toDTO(enrollmentRepository.save(enrollment));
    }
}