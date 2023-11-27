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
        List<Zoo> zoos = zooRepository.findAll();
        return zooMapper.entityListToDtoList(zoos);
    }

    @Override
    public ZooDto getZooById(Long id) {
        Zoo zoo = zooRepository.findById(id).orElse(null);
        return zoo != null ? zooMapper.entityToDto(zoo) : null;
    }

    @Override
    public void saveZoo(ZooDto zooDto) {
        Zoo zoo = zooMapper.dtoToEntity(zooDto);
        zooRepository.save(zoo);
    }

    @Override
    public void updateZoo(Long id, ZooDto updatedZooDto) {
        Zoo existingZoo = zooRepository.findById(id).orElse(null);
        if (existingZoo != null) {
            existingZoo.setName(updatedZooDto.getName());
            existingZoo.setLocation(updatedZooDto.getLocation());
            zooRepository.save(existingZoo);
        }
    }

    @Override
    public void deleteZoo(Long id) {
        zooRepository.deleteById(id);
    }
}
