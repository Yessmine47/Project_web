package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "stagiaires")
public class Stagiaire extends Utilisateur {

    private String sujet;
    private String encadrant;
    private Integer note;          // Champ pour la note
    private String commentaire;   // Champ pour le commentaire

    // Constructeur par défaut
    public Stagiaire() {
        super("", "", "", "", "stagiaire", ""); // Appel explicite au constructeur avec paramètres de Utilisateur
    }

    // Constructeur avec paramètres
    public Stagiaire(String nom, String prenom, String email, String telephone, String sujet, String encadrant, Integer note, String commentaire, String identifiant) {
        super(nom, prenom, email, telephone, "stagiaire", identifiant); // Appelle le constructeur de Utilisateur
        this.sujet = sujet;
        this.encadrant = encadrant;
        this.note = note;
        this.commentaire = commentaire;
    }

    // Getters et Setters
    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getEncadrant() {
        return encadrant;
    }

    public void setEncadrant(String encadrant) {
        this.encadrant = encadrant;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}



