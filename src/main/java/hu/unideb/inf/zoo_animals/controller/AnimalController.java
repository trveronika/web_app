package hu.unideb.inf.zoo_animals.controller;

import hu.unideb.inf.zoo_animals.model.Animal;
import hu.unideb.inf.zoo_animals.model.Zoo;
import hu.unideb.inf.zoo_animals.service.AnimalService;
import hu.unideb.inf.zoo_animals.service.ZooService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/animals")
@AllArgsConstructor
public class AnimalController {
    private final AnimalService animalService;
    private final ZooService zooService;

    @GetMapping("")
    public String getAllAnimals(Model model) {
        List<Animal> animals = animalService.getAllAnimals();
        model.addAttribute("animals", animals);
        return "animal-list";
    }

    @GetMapping("/{id}")
    public String getAnimalById(@PathVariable Long id, Model model) {
        Animal animal = animalService.getAnimalById(id);
        if (animal != null) {
            model.addAttribute("animal", animal);
            return "animal-details";
        } else {
            return "not-found";
        }
    }

    @GetMapping("/new")
    public String showAnimalForm(Model model) {
        List<Zoo> zoos = zooService.getAllZoos();
        model.addAttribute("zoos", zoos);
        model.addAttribute("animal", new Animal());
        return "animal-form";
    }

    @PostMapping("/save")
    public String saveAnimal(@ModelAttribute Animal animal) {
        animalService.saveAnimal(animal);
        return "redirect:/animals";
    }

    @GetMapping("/edit/{id}")
    public String showEditAnimalForm(@PathVariable Long id, Model model) {
        Animal animal = animalService.getAnimalById(id);
        List<Zoo> zoos = zooService.getAllZoos();
        model.addAttribute("zoos", zoos);
        model.addAttribute("animal", animal);
        return "animal-update-form";
    }

    @PostMapping("/edit/{id}")
    public String updateAnimal(@PathVariable Long id, @ModelAttribute Animal updatedAnimal) {
        animalService.updateAnimal(id, updatedAnimal);
        return "redirect:http://localhost:9092/api/animals";
    }

    @PostMapping("/delete/{id}")
    public String deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return "redirect:/animals";
    }

}
