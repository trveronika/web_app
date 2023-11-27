package hu.unideb.inf.zoo_animals.controller;

import hu.unideb.inf.zoo_animals.dto.ZooDto;
import hu.unideb.inf.zoo_animals.repository.ZooRepository;
import hu.unideb.inf.zoo_animals.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooController {
    @Autowired
    private final ZooService zooService;

    public ZooController(ZooService zooService) {
        this.zooService = zooService;
    }

    @GetMapping
    public ResponseEntity<List<ZooDto>> getAllZoos() {
        List<ZooDto> zoos = zooService.getAllZoos();
        return ResponseEntity.ok(zoos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZooDto> getZooById(@PathVariable Long id) {
        ZooDto zoo = zooService.getZooById(id);
        return zoo != null ? ResponseEntity.ok(zoo) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> saveZoo(@RequestBody ZooDto zooDto) {
        zooService.saveZoo(zooDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateZoo(@PathVariable Long id, @RequestBody ZooDto updatedZooDto) {
        zooService.updateZoo(id, updatedZooDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZoo(@PathVariable Long id) {
        zooService.deleteZoo(id);
        return ResponseEntity.ok().build();
    }
}
