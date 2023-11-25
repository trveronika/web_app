package hu.unideb.inf.zoo_animals.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Zoo")
public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name", unique = true)
    private String name;
    @Column(name="location")
    private String location;

    public Zoo() {
    }
    public Zoo(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zoo zoo = (Zoo) o;
        return Objects.equals(id, zoo.id) && Objects.equals(name, zoo.name) && Objects.equals(location, zoo.location);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, location);
    }
    @Override
    public String toString() {
        return "Zoo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
