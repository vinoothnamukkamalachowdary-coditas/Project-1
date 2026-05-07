package com.example.L.D_Platform.Controller;

import com.example.L.D_Platform.CommonResponse.APIResponse;
import com.example.L.D_Platform.DTO.AssignmentDTO;
import com.example.L.D_Platform.Repository.AssignmentRepository;
import com.example.L.D_Platform.Service.AssignmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/assignments")
@RequiredArgsConstructor
public class AssignmentController {
    private final AssignmentService service;

    @PostMapping
    public APIResponse<AssignmentDTO> create(@Valid @RequestBody AssignmentDTO assignmentDTO) {
        return new APIResponse<>(true,"Assignment Created",service.create(assignmentDTO));
    }

    @GetMapping
    public APIResponse<List<AssignmentDTO>> findAll(){
        return new APIResponse<>(true,"List of Assignments found",service.findAll());
    }
}
