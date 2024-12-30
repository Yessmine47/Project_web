package com.example.demo.service;

import com.example.demo.model.Encadrant;
import com.example.demo.repository.EncadrantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncadrantService {

    @Autowired
    private EncadrantRepository encadrantRepository;

    public List<Encadrant> findAll() {
        return encadrantRepository.findAll();
    }

    public Encadrant findById(Long id) {
        return encadrantRepository.findById(id).orElse(null);
    }

    public Encadrant save(Encadrant encadrant) {
        return encadrantRepository.save(encadrant);
    }

    public void deleteById(Long id) {
        encadrantRepository.deleteById(id);
    }
}



