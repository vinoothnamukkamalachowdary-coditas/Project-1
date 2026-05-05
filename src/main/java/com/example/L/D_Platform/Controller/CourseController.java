package com.example.L.D_Platform.Controller;

import com.example.L.D_Platform.CommonResponse.APIResponse;
import com.example.L.D_Platform.DTO.CourseDTO;
import com.example.L.D_Platform.Entity.Course;
import com.example.L.D_Platform.Service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseService service;

    @PostMapping
    public APIResponse<?> addCourse(@Valid @RequestBody CourseDTO course){
        return new APIResponse<>(true,"Created",service.addCourse(course));
    }
    @GetMapping
    public APIResponse getAllCourses(){
        return new APIResponse<>(true,"Fetched",service.getAllCourses());
    }
}
