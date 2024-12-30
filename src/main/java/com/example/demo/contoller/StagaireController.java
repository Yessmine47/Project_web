package com.example.demo.contoller;

import com.example.demo.model.Stagiaire;
import com.example.demo.model.Task;
import com.example.demo.service.StagiaireService;
import com.example.demo.service.SujetService;
import com.example.demo.service.EncadrantService;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/gestion-stagiaires")
public class StagaireController {

    @Autowired
    private StagiaireService stagiaireService;

    @Autowired
    private SujetService sujetService;

    @Autowired
    private EncadrantService encadrantService;

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String getAllStagiaires(Model model) {
        model.addAttribute("stagiaires", stagiaireService.getAllStagiaires());
        return "gestion-stagiaires";
    }

    @GetMapping("/edit-stagiaire")
    public String showAddStagiaireForm(Model model) {
        model.addAttribute("stagiaire", new Stagiaire());
        model.addAttribute("sujets", sujetService.getAllSujets());
        model.addAttribute("encadrants", encadrantService.findAll());
        return "edit-stagiaire";
    }

    @GetMapping("/edit-stagiaire/{id}")
    public String showEditStagiaireForm(@PathVariable("id") Long id, Model model) {
        Stagiaire stagiaire = stagiaireService.findById(id);
        model.addAttribute("stagiaire", stagiaire);
        model.addAttribute("sujets", sujetService.getAllSujets());
        model.addAttribute("encadrants", encadrantService.findAll());
        return "edit-stagiaire";
    }

    @PostMapping("/save")
    public String saveStagiaire(@ModelAttribute Stagiaire stagiaire) {
        stagiaireService.saveStagiaire(stagiaire);
        return "redirect:/gestion-stagiaires";
    }

    @GetMapping("/delete/{id}")
    public String deleteStagiaire(@PathVariable Long id) {
        stagiaireService.deleteStagiaire(id);
        return "redirect:/gestion-stagiaires";
    }

    @GetMapping("/performances/{id}")
    public String getPerformancePage(@PathVariable Long id, Model model) {
        Stagiaire stagiaire = stagiaireService.findById(id);
        model.addAttribute("stagiaire", stagiaire);
        return "performances";
    }

    @PostMapping("/performances/save")
    public String savePerformance(@RequestParam Long id, @RequestParam Integer note, @RequestParam String commentaire) {
        Stagiaire stagiaire = stagiaireService.findById(id);
        stagiaire.setNote(note);
        stagiaire.setCommentaire(commentaire);
        stagiaireService.saveStagiaire(stagiaire);
        return "redirect:/gestion-stagiaires";
    }

    // Gestion des tâches

    @GetMapping("/tasks/{stagiaireId}")
    public String listTasks(@PathVariable("stagiaireId") Long stagiaireId, Model model) {
        Stagiaire stagiaire = stagiaireService.findById(stagiaireId);
        if (stagiaire != null) {
            model.addAttribute("tasks", taskService.findByStagiaireId(stagiaireId));
            model.addAttribute("stagiaire", stagiaire);
        }
        return "tasks";
    }

    @GetMapping("/tasks/add")
    public String addTaskForm(@RequestParam("stagiaireId") Long stagiaireId, Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("stagiaireId", stagiaireId);
        return "add-task";
    }
    @GetMapping("/tasks/edit/{id}")
    public String editTaskForm(@PathVariable("id") Long id, Model model) {
        Task task = taskService.findById(id);
        if (task != null) {
            model.addAttribute("task", task);
            model.addAttribute("stagiaireId", task.getStagiaire().getId());
        }
        return "add-task";
    }

    @GetMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        Task task = taskService.findById(id);
        if (task != null) {
            Long stagiaireId = task.getStagiaire().getId();
            taskService.delete(id);
            return "redirect:/gestion-stagiaires/tasks/" + stagiaireId;
        }
        return "redirect:/gestion-stagiaires";
    }
}










