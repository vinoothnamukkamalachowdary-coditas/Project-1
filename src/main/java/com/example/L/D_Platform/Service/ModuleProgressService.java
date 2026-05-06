package com.example.L.D_Platform.Service;

import com.example.L.D_Platform.DTO.ModuleProgressDTO;
import com.example.L.D_Platform.Entity.Module;
import com.example.L.D_Platform.Entity.ModuleProgress;
import com.example.L.D_Platform.Entity.User;
import com.example.L.D_Platform.Mapper.ModuleProgressMapper;
import com.example.L.D_Platform.Repository.ModuleProgressRepository;
import com.example.L.D_Platform.Repository.ModuleRepository;
import com.example.L.D_Platform.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModuleProgressService {

    private final ModuleProgressRepository repo;
    private final UserRepository userRepo;
    private final ModuleRepository moduleRepo;
    private final ModuleProgressMapper mapper;

    public ModuleProgressDTO complete(ModuleProgressDTO dto) {
        User user = userRepo.findById(dto.getUserId()).orElseThrow();
        Module module = moduleRepo.findById(dto.getModuleId()).orElseThrow();

        ModuleProgress mp = mapper.toEntity(dto, user, module);
        return mapper.toDTO(repo.save(mp));
    }
}