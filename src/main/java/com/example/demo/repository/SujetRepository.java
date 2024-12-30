package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Sujet;
@Repository
public interface SujetRepository extends JpaRepository<Sujet, Long> {

}
