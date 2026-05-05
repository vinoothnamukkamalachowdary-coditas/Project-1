package com.example.L.D_Platform.Controller;

import com.example.L.D_Platform.CommonResponse.APIResponse;
import com.example.L.D_Platform.DTO.SubmissionDTO;
import com.example.L.D_Platform.Service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
@RequiredArgsConstructor
public class SubmissionController {
    private final SubmissionService service;

    @PostMapping
    public APIResponse<SubmissionDTO> submit(@RequestBody SubmissionDTO submissionDTO) {
        return new APIResponse<>(true, "Assignment Submitted",service.submit(submissionDTO));
    }

    @GetMapping
    public APIResponse<List<SubmissionDTO>> findAll() {
        return new APIResponse<>(true,"Fetched Submissions",service.findAll());
    }
}
