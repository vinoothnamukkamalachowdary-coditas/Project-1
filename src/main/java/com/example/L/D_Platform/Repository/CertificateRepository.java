package com.example.L.D_Platform.Repository;

import com.example.L.D_Platform.Entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificateRepository extends JpaRepository<Certificate,Long> {
    List<Certificate> findByUserId(Long userId);
}
