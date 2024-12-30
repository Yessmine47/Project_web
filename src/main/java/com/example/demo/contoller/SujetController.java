package com.example.demo.contoller;

import com.example.demo.model.Sujet;
import com.example.demo.service.SujetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sujets")
public class SujetController {

    @Autowired
    private SujetService sujetService;

    @GetMapping
    public String listSujets(Model model) {
        model.addAttribute("sujets", sujetService.getAllSujets());
        return "sujets";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("sujet", new Sujet());
        return "addsujet";
    }

    @PostMapping("/add")
    public String addSujet(@ModelAttribute Sujet sujet) {
        sujetService.saveSujet(sujet);
        return "redirect:/sujets";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("sujet", sujetService.getSujetById(id).orElse(new Sujet()));
        return "addsujet";
    }

    @PostMapping("/edit/{id}")
    public String updateSujet(@PathVariable("id") Long id, @ModelAttribute Sujet sujet) {
        sujet.setId(id);
        sujetService.saveSujet(sujet);
        return "redirect:/sujets";
    }

    @GetMapping("/delete/{id}")
    public String deleteSujet(@PathVariable("id") Long id) {
        sujetService.deleteSujet(id);
        return "redirect:/sujets";
    }
}

