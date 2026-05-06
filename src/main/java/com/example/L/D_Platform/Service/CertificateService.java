package com.example.L.D_Platform.Service;

import com.example.L.D_Platform.DTO.CertificateDTO;
import com.example.L.D_Platform.Entity.Certificate;
import com.example.L.D_Platform.Entity.Course;
import com.example.L.D_Platform.Entity.User;
import com.example.L.D_Platform.Mapper.CertificateMapper;
import com.example.L.D_Platform.Repository.CertificateRepository;
import com.example.L.D_Platform.Repository.CourseRepository;
import com.example.L.D_Platform.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CertificateService {
    private final CertificateRepository repo;
    private final UserRepository userRepo;
    private final CourseRepository courseRepo;
    private final CertificateMapper mapper;

    public CertificateDTO generate(CertificateDTO dto) {
        User user = userRepo.findById(dto.getUserId()).orElseThrow();
        Course course = courseRepo.findById(dto.getCourseId()).orElseThrow();

        Certificate cert = mapper.toEntity(dto, user, course);
        cert.setName(user.getName() + " - " + course.getTitle());

        return mapper.toDTO(repo.save(cert));

    }
}
