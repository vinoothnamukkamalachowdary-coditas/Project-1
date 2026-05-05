package com.example.L.D_Platform.Service;

import com.example.L.D_Platform.DTO.SubmissionDTO;
import com.example.L.D_Platform.Mapper.SubmissionMapper;
import com.example.L.D_Platform.Repository.SubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubmissionService {
    private final SubmissionRepository submissionRepository;
    private final SubmissionMapper Mapper;
    public SubmissionDTO submit(SubmissionDTO submissionDTO) {
        return Mapper.toDTO(submissionRepository.save(Mapper.toEntity(submissionDTO)));
    }

    public List<SubmissionDTO> findAll() {
        return submissionRepository.findAll().stream().map(Mapper::toDTO).toList();
    }
}
