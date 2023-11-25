package hu.unideb.inf.zoo_animals.controller;

import hu.unideb.inf.zoo_animals.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zoos")
public class ZooController {
    @Autowired
    ZooRepository zooRepository;

}
