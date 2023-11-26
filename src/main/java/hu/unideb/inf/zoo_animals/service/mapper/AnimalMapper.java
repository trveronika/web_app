package hu.unideb.inf.zoo_animals.service.mapper;

import hu.unideb.inf.zoo_animals.dto.AnimalDto;
import hu.unideb.inf.zoo_animals.model.Animal;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface AnimalMapper {
    AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);
    @Mapping(source = "animal.zoo.zooId", target = "zooId")
    @Mapping(source = "animal.zoo.zooName", target = "zooName")
    AnimalDto entityToDto(Animal animal);
    @Mapping(source = "zooId", target = "zoo.zooId")
    @Mapping(source = "zooName", target = "zoo.zooName")
    Animal dtoToEntity(AnimalDto animalDto);

    List<AnimalDto> entityListToDtoList(List<Animal> animalList);
}
