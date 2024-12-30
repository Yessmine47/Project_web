package com.example.demo.repository;
import com.example.demo.model.Encadrant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncadrantRepository extends JpaRepository <Encadrant, Long>{

}
