package hu.unideb.inf.repository;

import hu.unideb.inf.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseRepository  extends JpaRepository<House,Integer> {
    List<House> findAllByColourEqualsIgnoreCase(String colour);
}
