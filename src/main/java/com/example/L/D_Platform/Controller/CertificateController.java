package com.example.L.D_Platform.Controller;

import com.example.L.D_Platform.CommonResponse.APIResponse;
import com.example.L.D_Platform.DTO.CertificateDTO;
import com.example.L.D_Platform.Service.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/certificates")
@RequiredArgsConstructor
public class CertificateController {

    private final CertificateService service;

    @PostMapping("/generate")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public APIResponse<CertificateDTO> generate(@RequestBody CertificateDTO dto) {
        return new APIResponse<>(true, "Succefull Certificate Generation",service.generate(dto));
    }
}