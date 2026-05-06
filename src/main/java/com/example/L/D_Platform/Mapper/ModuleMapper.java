package com.example.L.D_Platform.Mapper;

import com.example.L.D_Platform.DTO.ModuleDTO;
import com.example.L.D_Platform.Entity.Course;
import com.example.L.D_Platform.Entity.Module;
import org.springframework.stereotype.Component;

@Component
public class ModuleMapper {
        public Module toEntity(ModuleDTO dto, Course course) {
            Module module = new Module();
            module.setId(dto.getId());
            module.setName(dto.getName());
            module.setLink(dto.getLink());
            module.setCourse(course);
            return module;
        }

        public ModuleDTO toDTO(Module module) {
            ModuleDTO dto = new ModuleDTO();
            dto.setId(module.getId());
            dto.setName(module.getName());
            dto.setLink(module.getLink());
            dto.setCourseId(module.getCourse().getId());
            return dto;
        }
}
