package com.example.L.D_Platform.Service;

import com.example.L.D_Platform.DTO.ModuleDTO;
import com.example.L.D_Platform.Entity.Course;
import com.example.L.D_Platform.Entity.Module;
import com.example.L.D_Platform.Mapper.ModuleMapper;
import com.example.L.D_Platform.Repository.CourseRepository;
import com.example.L.D_Platform.Repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleService {

    private final ModuleRepository repo;
    private final CourseRepository courseRepo;
    private final ModuleMapper mapper;

    public ModuleDTO create(ModuleDTO dto) {

        if (dto.getCourseId() == null) {
            throw new RuntimeException("Course ID must not be null");
        }

        Course course = courseRepo.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + dto.getCourseId()));

        Module module = mapper.toEntity(dto, course);

        return mapper.toDTO(repo.save(module));
    }
    public List<ModuleDTO> getAll() {
        return repo.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }
}