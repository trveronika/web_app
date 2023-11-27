package hu.unideb.inf.zoo_animals.service;

import hu.unideb.inf.zoo_animals.dto.AnimalDto;
import hu.unideb.inf.zoo_animals.model.Animal;

import java.util.List;

public interface AnimalService {
    List<AnimalDto> getAllAnimals();

    AnimalDto getAnimalById(Long id);

    void saveAnimal(AnimalDto animal);

    void updateAnimal(Long id, AnimalDto updatedAnimal);

    void deleteAnimal(Long id);
}
