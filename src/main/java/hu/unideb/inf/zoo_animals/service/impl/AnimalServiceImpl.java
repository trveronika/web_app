package hu.unideb.inf.zoo_animals.service.impl;

import hu.unideb.inf.zoo_animals.model.Animal;
import hu.unideb.inf.zoo_animals.model.Zoo;
import hu.unideb.inf.zoo_animals.repository.AnimalRepository;
import hu.unideb.inf.zoo_animals.repository.ZooRepository;
import hu.unideb.inf.zoo_animals.service.AnimalService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;

    private final ZooRepository zooRepository;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository,ZooRepository zooRepository) {
        this.animalRepository = animalRepository;
        this.zooRepository=zooRepository;
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public Animal getAnimalById(Long id) {
        Optional<Animal> optionalAnimal = animalRepository.findById(id);
        if (optionalAnimal.isPresent()) {
            return optionalAnimal.get();
        } else {
            throw new EntityNotFoundException("Animal not found with ID: " + id);
        }
    }

    @Override
    public void saveAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    @Override
    public void saveAnimal(Long zooId, Animal animal) {
        Zoo zoo = zooRepository.findById(zooId).orElseThrow(() -> new EntityNotFoundException("Zoo not found with ID: " + zooId));
        animal.setZoo(zoo);
        animalRepository.save(animal);
    }

    @Override
    public void updateAnimal(Long id, Animal updatedAnimal) {
        Animal existingAnimal = animalRepository.findById(id).orElse(null);
        if (existingAnimal != null) {
            existingAnimal.setType(updatedAnimal.getType());
            existingAnimal.setColour(updatedAnimal.getColour());
            existingAnimal.setZoo(updatedAnimal.getZoo());
            // Update other properties as needed

            animalRepository.save(existingAnimal);
        } else {
            // Handle the case where the animal with the given id is not found
            throw new EntityNotFoundException("Animal not found with ID: " + id);
        }
    }

    @Override
    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }
}