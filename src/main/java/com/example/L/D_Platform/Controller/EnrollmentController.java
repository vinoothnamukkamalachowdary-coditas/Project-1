package com.example.L.D_Platform.Controller;

import com.example.L.D_Platform.CommonResponse.APIResponse;
import com.example.L.D_Platform.DTO.EnrollmentDTO;
import com.example.L.D_Platform.Service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService service;

    @PostMapping
    public APIResponse<EnrollmentDTO> enrollment(@RequestBody EnrollmentDTO enroll) {
        return new APIResponse<>(true, "Enrolled successfully", service.enrollment(enroll));
    }

    @GetMapping("/user/{id}")
    public APIResponse<List<EnrollmentDTO>> getEnrollment(@PathVariable Long id) {
        return new APIResponse<>(true, "Enrollments fetched", service.getEnrollment(id));
    }

    @PutMapping("/{id}/progress")
    public APIResponse<EnrollmentDTO> updateProgress(@PathVariable Long id,
                                                     @RequestParam int progress) {
        return new APIResponse<>(true, "Progress updated", service.updateProgress(id, progress));
    }
}