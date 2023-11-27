package hu.unideb.inf.zoo_animals.service.impl;

import hu.unideb.inf.zoo_animals.dto.ZooDto;
import hu.unideb.inf.zoo_animals.model.Zoo;
import hu.unideb.inf.zoo_animals.repository.AnimalRepository;
import hu.unideb.inf.zoo_animals.repository.ZooRepository;
import hu.unideb.inf.zoo_animals.service.ZooService;
import hu.unideb.inf.zoo_animals.service.mapper.ZooMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZooServiceImpl implements ZooService {
    private final ZooRepository zooRepository;
    private final ZooMapper zooMapper;

    private final AnimalRepository animalRepository;


    @Autowired
    public ZooServiceImpl(ZooRepository zooRepository, ZooMapper zooMapper, AnimalRepository animalRepository) {
        this.zooRepository = zooRepository;
        this.zooMapper = zooMapper;
        this.animalRepository = animalRepository;
    }

    @Override
    public List<ZooDto> getAllZoos() {
        return null;
    }

    @Override
    public ZooDto getZooById(Long id) {
        return null;
    }

    @Override
    public void saveZoo(ZooDto zoo) {

    }

    @Override
    public void updateZoo(Long id, ZooDto updatedZoo) {

    }

    @Override
    public void deleteZoo(Long id) {

    }
}
