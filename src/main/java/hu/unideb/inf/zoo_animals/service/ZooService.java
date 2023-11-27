package hu.unideb.inf.zoo_animals.service;

import hu.unideb.inf.zoo_animals.dto.ZooDto;
import hu.unideb.inf.zoo_animals.model.Zoo;

import java.util.List;

public interface ZooService {
    List<ZooDto> getAllZoos();

    ZooDto getZooById(Long id);

    void saveZoo(ZooDto zoo);

    void updateZoo(Long id, ZooDto updatedZoo);

    void deleteZoo(Long id);
}
