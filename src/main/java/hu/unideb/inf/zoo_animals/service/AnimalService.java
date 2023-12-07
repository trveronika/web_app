package hu.unideb.inf.zoo_animals.service;

import hu.unideb.inf.zoo_animals.model.Animal;

import java.util.List;

public interface AnimalService {
    List<Animal> getAllAnimals();

    Animal getAnimalById(Long id);

    void saveAnimal(Animal animalDto);

    void saveAnimal(Long zooId, Animal animal);

    void updateAnimal(Long id, Animal updatedAnimalDto);

    void deleteAnimal(Long id);
}
