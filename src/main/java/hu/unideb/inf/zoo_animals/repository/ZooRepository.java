package hu.unideb.inf.zoo_animals.repository;

import hu.unideb.inf.zoo_animals.model.Animal;
import hu.unideb.inf.zoo_animals.model.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZooRepository extends JpaRepository<Zoo,Long> {
    List<Zoo> findAllByZooNameEqualsIgnoreCase(String name);
}
