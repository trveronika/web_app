package hu.unideb.inf.zoo_animals.controller;

import hu.unideb.inf.zoo_animals.model.Zoo;
import hu.unideb.inf.zoo_animals.service.ZooService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zoos")
@AllArgsConstructor
public class ZooController {
    @Autowired
    private final ZooService zooService;
    @GetMapping("")
    public ResponseEntity<List<Zoo>> getAllZoos() {
        List<Zoo> zoos = zooService.getAllZoos();
        return ResponseEntity.ok(zoos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zoo> getZooById(@PathVariable Long id) {
        Zoo zoo = zooService.getZooById(id);
        return zoo != null ? ResponseEntity.ok(zoo) : ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<Void> saveZoo(@RequestBody Zoo zoo) {
        zooService.saveZoo(zoo);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateZoo(@PathVariable Long id, @RequestBody Zoo updatedZoo) {
        zooService.updateZoo(id, updatedZoo);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZoo(@PathVariable Long id) {
        zooService.deleteZoo(id);
        return ResponseEntity.ok().build();
    }
}
