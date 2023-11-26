package hu.unideb.inf.zoo_animals.service;

import hu.unideb.inf.zoo_animals.model.Zoo;

import java.util.List;

public interface ZooService {
    List<Zoo> getAllZoos();

    Zoo getZooById(Long id);

    void saveZoo(Zoo zoo);

    void updateZoo(Long id, Zoo updatedZoo);

    void deleteZoo(Long id);
}
