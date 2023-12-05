package hu.unideb.inf.zoo_animals.service;


import hu.unideb.inf.zoo_animals.model.Zoo;

import java.util.List;

public interface ZooService {
    List<Zoo> getAllZoos();

    Zoo getZooById(Long id);

    void saveZoo(Zoo zooDto);

    void updateZoo(Long id, Zoo updatedZooDto);

    void deleteZoo(Long id);
}
