package com.example.L.D_Platform.Mapper;

import com.example.L.D_Platform.DTO.ModuleProgressDTO;
import com.example.L.D_Platform.Entity.ModuleProgress;
import com.example.L.D_Platform.Entity.User;
import com.example.L.D_Platform.Entity.Module;
import org.springframework.stereotype.Component;

@Component
public class ModuleProgressMapper {

    public ModuleProgress toEntity(ModuleProgressDTO dto, User user, Module module) {
        ModuleProgress mp = new ModuleProgress();
        mp.setId(dto.getId());
        mp.setUser(user);
        mp.setModule(module);
        mp.setCompleted(dto.isCompleted());
        return mp;
    }

    public ModuleProgressDTO toDTO(ModuleProgress mp) {
        ModuleProgressDTO dto = new ModuleProgressDTO();
        dto.setId(mp.getId());
        dto.setUserId(mp.getUser().getId());
        dto.setModuleId(mp.getModule().getId());
        dto.setCompleted(mp.isCompleted());
        return dto;
    }
}