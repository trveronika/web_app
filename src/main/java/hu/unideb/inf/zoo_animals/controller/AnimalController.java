package hu.unideb.inf.zoo_animals.controller;

import hu.unideb.inf.zoo_animals.dto.AnimalDto;
import hu.unideb.inf.zoo_animals.service.AnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AnimalController {
    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }
    @GetMapping
    public ResponseEntity<List<AnimalDto>> getAllAnimals() {
        List<AnimalDto> dogs = animalService.getAllAnimals();
        return new ResponseEntity<>(dogs, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AnimalDto> getAnimalById(@PathVariable Long id) {
        AnimalDto animal = animalService.getAnimalById(id);
        return animal != null ? ResponseEntity.ok(animal) : ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<Void> saveAnimal(@RequestBody AnimalDto animalDto) {
        animalService.saveAnimal(animalDto);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAnimal(@PathVariable Long id, @RequestBody AnimalDto updatedAnimalDto) {
        animalService.updateAnimal(id, updatedAnimalDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return ResponseEntity.ok().build();
    }
}
