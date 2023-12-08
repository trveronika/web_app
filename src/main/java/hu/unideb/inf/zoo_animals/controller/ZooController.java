package hu.unideb.inf.zoo_animals.controller;

import hu.unideb.inf.zoo_animals.model.Zoo;
import hu.unideb.inf.zoo_animals.service.ZooService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@RestController
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
}*/
@Controller
@RequestMapping("/zoos")
@AllArgsConstructor
public class ZooController {
    private final ZooService zooService;

    @GetMapping("") //működik
    public String getAllZoos(Model model) {
        List<Zoo> zoos = zooService.getAllZoos();
        model.addAttribute("zoos", zoos);
        return "zoo-list";
    }

    @GetMapping("/{id}") //működik de rosszul néz ki, kellene egy táblázat
    public String getZooById(@PathVariable Long id, Model model) {
        Zoo zoo = zooService.getZooById(id);
        if (zoo != null) {
            model.addAttribute("zoo", zoo);
            return "zoo-details"; // Assuming you have a Thymeleaf template named "zoo-details.html"
        } else {
            return "not-found"; // Assuming you have a Thymeleaf template named "not-found.html"
        }
    }
    @GetMapping("/new") //a form megjelenik, és hozzá is adódik a zoo, vissza is irányít a zoo listre (nice)
    public String showZooForm(Model model) {
        model.addAttribute("zoo", new Zoo());
        return "zoo-form";
    }

    @PostMapping("/save") //működik a mentés
    public String saveZoo(@ModelAttribute Zoo zoo) {
        zooService.saveZoo(zoo);
        // Redirect to the list of zoos after saving
        return "redirect:http://localhost:9092/api/zoos";
    }

    @GetMapping("/edit/{id}")
    public String showEditZooForm(@PathVariable Long id, Model model) {
        Zoo zoo = zooService.getZooById(id);
        model.addAttribute("zoo", zoo);
        return "zoo-update-form";
    }

    @PostMapping("/edit/{id}")
    public String updateZoo(@PathVariable Long id, @ModelAttribute Zoo updatedZoo) {
        zooService.updateZoo(id, updatedZoo);
        return "redirect:http://localhost:9092/api/zoos"; // Redirect to the zoo list page
    }

    @PostMapping("/delete/{id}") //nem működik
    public String deleteZoo(@PathVariable Long id) {
        zooService.deleteZoo(id);
        return "redirect:http://localhost:9092/api/zoos"; // Redirect to the zoo list page
    }
}
