package hu.unideb.inf.zoo_animals.service;

import hu.unideb.inf.zoo_animals.dto.ZooDto;
import hu.unideb.inf.zoo_animals.model.Zoo;

import java.util.List;

public interface ZooService {
    List<ZooDto> getAllZoos();

    ZooDto getZooById(Long id);

    void saveZoo(ZooDto zooDto);

    void updateZoo(Long id, ZooDto updatedZooDto);

    void deleteZoo(Long id);
}
