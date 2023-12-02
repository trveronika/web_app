package hu.unideb.inf.zoo_animals.repository;

import hu.unideb.inf.zoo_animals.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal,Long> {
    List<Animal> findAllByTypeOrderByZoo(String name);
}
