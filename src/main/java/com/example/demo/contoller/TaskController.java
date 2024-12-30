package com.example.demo.contoller; 
import com.example.demo.model.Stagiaire;
import com.example.demo.model.Task;
import com.example.demo.service.StagiaireService;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private StagiaireService stagiaireService;


    @GetMapping("/tasks/{stagiaireId}")
    public String listTasks(@PathVariable("stagiaireId") Long stagiaireId, Model model) {
        Stagiaire stagiaire = stagiaireService.findById(stagiaireId);
        if (stagiaire != null) {
            model.addAttribute("tasks", taskService.findByStagiaireId(stagiaireId));
            model.addAttribute("stagiaire", stagiaire);
        }
        return "tasks";
    }


    @GetMapping("/add")
    public String addTaskForm(@RequestParam("stagiaireId") Long stagiaireId, Model model) {
        model.addAttribute("task", new Task()); 
        model.addAttribute("stagiaireId", stagiaireId);
        return "add-task"; 
    }

    @PostMapping("/save")
    public String saveTask(@ModelAttribute("task") Task task, @RequestParam("stagiaireId") Long stagiaireId) {
        taskService.save(task); 
        return "redirect:/tasks" + stagiaireId; // Redirection après enregistrement
    }

    @GetMapping("/edit/{id}")
    public String editTaskForm(@PathVariable("id") Long id, Model model) {
        Task task = taskService.findById(id); // Récupération de la tâche
        if (task == null) {
            return "redirect:/tasks"; // Redirection en cas d'erreur
        }
        model.addAttribute("task", task);
        model.addAttribute("stagiaireId", task.getStagiaire().getId()); // ID du stagiaire associé
        return "add-task"; // Nom du fichier de vue
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        Task task = taskService.findById(id); // Récupération de la tâche
        if (task == null) {
            return "redirect:/tasks"; // Redirection en cas d'erreur
        }
        Long stagiaireId = task.getStagiaire().getId();
        taskService.delete(id); // Suppression de la tâche
        return "redirect:/tasks/" + stagiaireId; // Redirection après suppression
    }
}



