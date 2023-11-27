package hu.unideb.inf.zoo_animals.service.impl;

import hu.unideb.inf.zoo_animals.dto.AnimalDto;
import hu.unideb.inf.zoo_animals.model.Animal;
import hu.unideb.inf.zoo_animals.repository.AnimalRepository;
import hu.unideb.inf.zoo_animals.service.AnimalService;
import hu.unideb.inf.zoo_animals.service.mapper.AnimalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;

    private final AnimalMapper animalMapper;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository, AnimalMapper animalMapper) {
        this.animalRepository = animalRepository;
        this.animalMapper = animalMapper;
    }


    @Override
    public List<AnimalDto> getAllAnimals() {
        List<Animal> animals = animalRepository.findAll();
        return animalMapper.entityListToDtoList(animals);
    }

    @Override
    public AnimalDto getAnimalById(Long id) {
        Animal animal = animalRepository.findById(id).orElse(null);
        return animal != null ? animalMapper.entityToDto(animal) : null;
    }

    @Override
    public void saveAnimal(AnimalDto animalDto) {
        Animal animal = animalMapper.dtoToEntity(animalDto);
        animalRepository.save(animal);
    }

    @Override
    public void updateAnimal(Long id, AnimalDto updatedAnimalDto) {
        Animal existingAnimal = animalRepository.findById(id).orElse(null);
        if (existingAnimal != null) {
            existingAnimal.setType(updatedAnimalDto.getType());
            existingAnimal.setName(updatedAnimalDto.getName());
            existingAnimal.setAge(updatedAnimalDto.getAge());
            existingAnimal.setColour(updatedAnimalDto.getColour());
            existingAnimal.setZoo(updatedAnimalDto.getZoo());
            animalRepository.save(existingAnimal);
        }
    }

    @Override
    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }
}
