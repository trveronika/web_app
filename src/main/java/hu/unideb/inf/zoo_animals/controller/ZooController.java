package hu.unideb.inf.zoo_animals.controller;

import hu.unideb.inf.zoo_animals.model.Zoo;
import hu.unideb.inf.zoo_animals.service.ZooService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/zoos")
@AllArgsConstructor
public class ZooController {
    private final ZooService zooService;

    @GetMapping("") //működik
    public String getAllZoos(Model model) {
        List<Zoo> zoos = zooService.getAllZoos();
        model.addAttribute("zoos", zoos);
        return "zoo-list";
    }

    @GetMapping("/{id}")
    public String getZooById(@PathVariable Long id, Model model) {
        Zoo zoo = zooService.getZooById(id);
        if (zoo != null) {
            model.addAttribute("zoo", zoo);
            return "zoo-details";
        } else {
            return "not-found";
        }
    }
    @GetMapping("/new")
    public String showZooForm(Model model) {
        model.addAttribute("zoo", new Zoo());
        return "zoo-form";
    }

    @PostMapping("/save") //működik a mentés
    public String saveZoo(@ModelAttribute Zoo zoo) {
        zooService.saveZoo(zoo);
        return "redirect:http://localhost:9092/api/zoos";
    }

    @GetMapping("/edit/{id}")
    public String showEditZooForm(@PathVariable Long id, Model model) {
        Zoo zoo = zooService.getZooById(id);
        model.addAttribute("zoo", zoo);
        return "zoo-update-form";
    }

    @PostMapping("/edit/{id}")
    public String updateZoo(@PathVariable Long id, @ModelAttribute Zoo updatedZoo) {
        zooService.updateZoo(id, updatedZoo);
        return "redirect:http://localhost:9092/api/zoos";
    }

    @PostMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable Long id) {
        zooService.deleteZoo(id);
        return "redirect:/zoos";
    }
}
