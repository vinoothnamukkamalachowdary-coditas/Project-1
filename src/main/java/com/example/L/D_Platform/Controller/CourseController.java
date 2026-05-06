package com.example.L.D_Platform.Controller;

import com.example.L.D_Platform.CommonResponse.APIResponse;
import com.example.L.D_Platform.DTO.CourseDTO;
import com.example.L.D_Platform.Service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;

    @PostMapping
    public APIResponse<CourseDTO> addCourse(@RequestBody CourseDTO course) {
        return new APIResponse<>(true, "Course created", service.addCourse(course));
    }

    @GetMapping
    public APIResponse<List<CourseDTO>> getAllCourses() {
        return new APIResponse<>(true, "Courses fetched", service.getAllCourses());
    }

    @GetMapping("/{id}")
    public APIResponse<CourseDTO> getCourseById(@PathVariable Long id) {
        return new APIResponse<>(true, "Course fetched", service.getCourseById(id));
    }

    @PutMapping("/{id}")
    public APIResponse<CourseDTO> updateCourse(@PathVariable Long id,
                                               @RequestBody CourseDTO course) {
        return new APIResponse<>(true, "Course updated", service.updateCourse(id, course));
    }

    @DeleteMapping("/{id}")
    public APIResponse<?> deleteCourse(@PathVariable Long id) {
        service.deleteCourse(id);
        return new APIResponse<>(true, "Course deleted", null);
    }
}