package com.example.L.D_Platform.Service;

import com.example.L.D_Platform.DTO.AssignmentDTO;
import com.example.L.D_Platform.Mapper.AssignmentMapper;
import com.example.L.D_Platform.Repository.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final AssignmentMapper mapper;

    public AssignmentDTO create(AssignmentDTO assignmentDTO) {
        return mapper.toDTO(assignmentRepository.save(mapper.toEntity(assignmentDTO)));
    }

    public List<AssignmentDTO> findAll() {
        return assignmentRepository.findAll().stream().map(mapper::toDTO).toList();
    }
}
