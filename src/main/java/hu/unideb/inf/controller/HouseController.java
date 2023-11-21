package hu.unideb.inf.controller;

import hu.unideb.inf.model.House;
import hu.unideb.inf.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HouseController {
    @Autowired
    HouseRepository houseRepository;

    @GetMapping("/allhouses")
    public List<House> findAll() {
        return houseRepository.findAll();
    }

    /*
    TODO:
    - list houses by ID (getmapping)
    - create houses (putmapping)
    - deletemapping (by id, all houses)
    - update houses
     */
}
