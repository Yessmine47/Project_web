package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "encadrants")
public class Encadrant extends Utilisateur {

    // Constructeur par défaut
    public Encadrant() {
        super("", "", "", "", "encadrant", ""); // Appelle le constructeur de Utilisateur avec des valeurs par défaut
    }

    // Constructeur avec paramètres
    public Encadrant(String nom, String prenom, String email, String telephone, String identifiant) {
        super(nom, prenom, email, telephone, "encadrant", identifiant); // Appelle le constructeur de Utilisateur avec des valeurs spécifiques
    }
}




