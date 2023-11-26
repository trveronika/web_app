package hu.unideb.inf.zoo_animals.service;

import hu.unideb.inf.zoo_animals.model.Animal;

import java.util.List;

public interface AnimalService {
    List<Animal> getAllAnimals();

    Animal getAnimalById(Long id);

    void saveAnimal(Animal animal);

    void updateAnimal(Long id, Animal updatedAnimal);

    void deleteAnimal(Long id);
}
