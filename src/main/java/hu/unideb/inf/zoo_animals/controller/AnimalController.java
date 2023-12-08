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

/*@RestController
@RequestMapping("/animals")
@AllArgsConstructor
public class AnimalController {
    private final AnimalService animalService;

    @GetMapping("")
    public ResponseEntity<List<Animal>> getAllAnimals() {
        List<Animal> animals = animalService.getAllAnimals();
        return new ResponseEntity<>(animals, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Long id) {
        Animal animal = animalService.getAnimalById(id);
        return animal != null ? ResponseEntity.ok(animal) : ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<Void> saveAnimal(@RequestBody Animal animal) {
        animalService.saveAnimal(animal);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{zooId}")
    public ResponseEntity<Void> saveAnimal(@PathVariable Long zooId, @RequestBody Animal animal) {
        animalService.saveAnimal(zooId, animal);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAnimal(@PathVariable Long id, @RequestBody Animal updatedAnimal) {
        animalService.updateAnimal(id, updatedAnimal);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return ResponseEntity.ok().build();
    }
}*/
@Controller
@RequestMapping("/animals")
@AllArgsConstructor
public class AnimalController {
    private final AnimalService animalService;
    private final ZooService zooService;  // Assuming you have a ZooService

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
            return "animal-details"; // Assuming you have a Thymeleaf template named "animal-details.html"
        } else {
            return "not-found"; // Assuming you have a Thymeleaf template named "not-found.html"
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
