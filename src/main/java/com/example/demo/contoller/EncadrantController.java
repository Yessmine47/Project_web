package com.example.demo.contoller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.Encadrant;
import com.example.demo.service.EncadrantService;

@Controller
@RequestMapping("/encadrants")
public class EncadrantController {

    @Autowired
    private EncadrantService encadrantService;

    @GetMapping
    public String listEncadrants(Model model) {
        model.addAttribute("encadrants", encadrantService.findAll());
        return "encadrants";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("encadrant", new Encadrant());
        return "add-encadrant";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Encadrant encadrant = encadrantService.findById(id);
        model.addAttribute("encadrant", encadrant);
        return "add-encadrant";
    }

    @PostMapping("/add")
    public String addEncadrant(Encadrant encadrant) {
        encadrantService.save(encadrant);
        return "redirect:/encadrants";
    }

    @PostMapping("/edit/{id}")
    public String editEncadrant(@PathVariable("id") Long id, Encadrant encadrant) {
        encadrant.setId(id);
        encadrantService.save(encadrant);
        return "redirect:/encadrants";
    }

    @GetMapping("/delete/{id}")
    public String deleteEncadrant(@PathVariable("id") Long id) {
        encadrantService.deleteById(id);
        return "redirect:/encadrants";
    }
}
