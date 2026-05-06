package com.example.L.D_Platform.Controller;

import com.example.L.D_Platform.CommonResponse.APIResponse;
import com.example.L.D_Platform.DTO.ModuleProgressDTO;
import com.example.L.D_Platform.Service.ModuleProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/progress")
@RequiredArgsConstructor
public class ModuleProgressController {

    private final ModuleProgressService service;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public APIResponse<ModuleProgressDTO> complete(@RequestBody ModuleProgressDTO dto) {
        return new APIResponse<>(true,"Progress Tracked",service.complete(dto));
    }
}