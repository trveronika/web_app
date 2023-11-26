package hu.unideb.inf.zoo_animals.service.mapper;

import hu.unideb.inf.zoo_animals.dto.ZooDto;
import hu.unideb.inf.zoo_animals.model.Zoo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ZooMapper {
    ZooMapper INSTANCE = Mappers.getMapper(ZooMapper.class);
    ZooDto entityToDto(Zoo zoo);
    Zoo dtoToEntity(ZooDto zooDto);
    List<ZooDto> entityListToDtoList(List<Zoo> zooList);
}
