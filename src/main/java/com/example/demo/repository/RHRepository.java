package com.example.demo.repository;

import com.example.demo.model.RH;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RHRepository extends JpaRepository<RH, Long> {
    RH findByEmail(String email);
}

