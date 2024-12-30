package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Stagiaire;

import com.example.demo.repository.StagiaireRepository;

@Service
public class StagiaireService {

    @Autowired
    private StagiaireRepository stagiaireRepository;


    // Méthodes pour les stagiaires

    public List<Stagiaire> getAllStagiaires() {
        return stagiaireRepository.findAll();
    }

    public void saveStagiaire(Stagiaire stagiaire) {
        stagiaireRepository.save(stagiaire);
    }

    public void deleteStagiaire(Long id) {
        stagiaireRepository.deleteById(id);
    }

    public Stagiaire findById(Long id) {
        return stagiaireRepository.findById(id).orElse(null);
    }
}


