package com.example.L.D_Platform.Service;

import com.example.L.D_Platform.DTO.CourseDTO;
import com.example.L.D_Platform.Entity.Course;
import com.example.L.D_Platform.Exception.ResourceNotFound;
import com.example.L.D_Platform.Mapper.CourseMapper;
import com.example.L.D_Platform.Repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    // POST /api/courses
    public CourseDTO addCourse(CourseDTO dto) {
        return courseMapper.toDTO(courseRepository.save(courseMapper.toEntity(dto)));
    }

    // GET /api/courses
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toDTO)
                .toList();
    }

    // GET /api/courses/{id}
    public CourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Course not found with id: " + id));
        return courseMapper.toDTO(course);
    }

    // PUT /api/courses/{id}
    public CourseDTO updateCourse(Long id, CourseDTO dto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Course not found with id: " + id));
        courseMapper.updateEntity(course, dto);
        return courseMapper.toDTO(courseRepository.save(course));
    }

    // DELETE /api/courses/{id}
    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new ResourceNotFound("Course not found with id: " + id);
        }
        courseRepository.deleteById(id);
    }

    // used internally by enrollment service
    public Course getById(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFound("Course not found with id: " + courseId));
    }
}