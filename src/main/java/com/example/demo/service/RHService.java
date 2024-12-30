package com.example.demo.service;

import com.example.demo.model.RH;
import com.example.demo.repository.RHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RHService {

    @Autowired
    private RHRepository rhRepository;

    public RH findByEmail(String email) {
        return rhRepository.findByEmail(email);
    }
}

