package hu.unideb.inf.zoo_animals.service.mapper;

import hu.unideb.inf.zoo_animals.dto.AnimalDto;
import hu.unideb.inf.zoo_animals.model.Animal;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AnimalMapper {
    AnimalDto entityToDto(Animal animal);
    Animal dtoToEntity(AnimalDto animalDto);
    List<AnimalDto> entityListToDtoList(List<Animal> zooList);
}
