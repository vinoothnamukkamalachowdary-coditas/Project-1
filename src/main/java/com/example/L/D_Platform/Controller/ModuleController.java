package com.example.L.D_Platform.Controller;

import com.example.L.D_Platform.CommonResponse.APIResponse;
import com.example.L.D_Platform.DTO.ModuleDTO;
import com.example.L.D_Platform.Service.ModuleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/modules")
@RequiredArgsConstructor
public class ModuleController {

    private final ModuleService service;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public APIResponse<ModuleDTO> create(@Valid @RequestBody ModuleDTO dto) {
        return new APIResponse<>(true, "Module Creation Done",service.create(dto));
    }

    @GetMapping
    public APIResponse<List<ModuleDTO>> getAll() {
        return new APIResponse<>(true, "Fetching all Modules",service.getAll());
    }
}