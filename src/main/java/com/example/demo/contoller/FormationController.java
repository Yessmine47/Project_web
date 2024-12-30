package com.example.demo.contoller;

import com.example.demo.model.Formation;
import com.example.demo.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/formation")
public class FormationController {

    @Autowired
    private FormationService formationService;

    // Afficher la liste des formations
    @GetMapping
    public String listFormations(Model model) {
        model.addAttribute("formations", formationService.getAllFormations());
        return "formation";
    }

    // Afficher le formulaire d'ajout
    @GetMapping("/add")
    public String showAddFormationForm(Model model) {
        model.addAttribute("formation", new Formation());
        return "addformation";
    }

    // Afficher le formulaire de modification
    @GetMapping("/edit/{id}")
    public String showEditFormationForm(@PathVariable("id") Long id, Model model) {
        Formation formation = formationService.getFormationById(id).orElseThrow(() -> new IllegalArgumentException("Invalid formation id:" + id));
        model.addAttribute("formation", formation);
        return "addformation";
    }

    // Ajouter ou modifier une formation
    @PostMapping("/save")
    public String saveFormation(@ModelAttribute Formation formation) {
        formationService.saveFormation(formation);
        return "redirect:/formation";
    }

    // Supprimer une formation
    @GetMapping("/delete/{id}")
    public String deleteFormation(@PathVariable("id") Long id) {
        formationService.deleteFormation(id);
        return "redirect:/formation";
    }
}














