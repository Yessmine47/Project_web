package com.example.demo.contoller; // Remplace par le package approprié

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    
    @GetMapping("/plannings")
    public String showPlanning(Model model) {
        // Ajoute des attributs au modèle si nécessaire
        return "plannings"; // Nom du modèle sans l'extension .html
    }

    @GetMapping("/performances")
    public String showPerformances(Model model) {
        // Ajoute des attributs au modèle si nécessaire
        return "performances"; // Nom du modèle sans l'extension .html
    }
}

