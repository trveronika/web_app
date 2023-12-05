package hu.unideb.inf.zoo_animals.service.impl;

import hu.unideb.inf.zoo_animals.model.Zoo;
import hu.unideb.inf.zoo_animals.repository.ZooRepository;
import hu.unideb.inf.zoo_animals.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZooServiceImpl implements ZooService {
    private final ZooRepository zooRepository;

    @Autowired
    public ZooServiceImpl(ZooRepository zooRepository) {
        this.zooRepository = zooRepository;
    }

    @Override
    public List<Zoo> getAllZoos() {
        return zooRepository.findAll();
    }

    @Override
    public Zoo getZooById(Long id) {
        return zooRepository.findById(id).orElse(null);
    }

    @Override
    public void saveZoo(Zoo zoo) {
        zooRepository.save(zoo);
    }

    @Override
    public void updateZoo(Long id, Zoo updatedZoo) {
        Zoo existingZoo = zooRepository.findById(id).orElse(null);
        if (existingZoo != null) {
            existingZoo.setZooName(updatedZoo.getZooName());
            existingZoo.setLocation(updatedZoo.getLocation());
            zooRepository.save(existingZoo);
        }
    }

    @Override
    public void deleteZoo(Long id) {
        zooRepository.deleteById(id);
    }
}

