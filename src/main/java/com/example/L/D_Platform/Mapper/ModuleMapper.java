package com.example.L.D_Platform.Mapper;

import com.example.L.D_Platform.DTO.ModuleDTO;
import com.example.L.D_Platform.Entity.Course;
import com.example.L.D_Platform.Entity.Module;
import org.springframework.stereotype.Component;

@Component
public class ModuleMapper {

    public Module toEntity(ModuleDTO dto, Course course) {

        if (dto == null) {
            return null;
        }

        Module module = new Module();

        module.setId(dto.getId());
        module.setName(dto.getName());
        module.setLink(dto.getLink());

        // Set parent entity
        module.setCourse(course);

        return module;
    }

    public ModuleDTO toDTO(Module module) {

        if (module == null) {
            return null;
        }

        ModuleDTO dto = new ModuleDTO();

        dto.setId(module.getId());
        dto.setName(module.getName());
        dto.setLink(module.getLink());

        // Prevent circular recursion
        if (module.getCourse() != null) {
            dto.setCourseId(module.getCourse().getId());
        }

        return dto;
    }

    public void updateEntity(Module module, ModuleDTO dto, Course course) {

        if (dto.getName() != null) {
            module.setName(dto.getName());
        }

        if (dto.getLink() != null) {
            module.setLink(dto.getLink());
        }

        if (course != null) {
            module.setCourse(course);
        }
    }
}
