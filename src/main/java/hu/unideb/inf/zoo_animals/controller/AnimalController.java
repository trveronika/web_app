package hu.unideb.inf.zoo_animals.controller;

import hu.unideb.inf.zoo_animals.model.Animal;
import hu.unideb.inf.zoo_animals.service.AnimalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
}
