package hu.unideb.inf.zoo_animals.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Zoo")
public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long zooId;
    @Column(name="name", unique = true)
    private String zooName;
    @Column(name="location")
    private String location;

    public Zoo() {
    }
    public Zoo(Long id, String name, String location) {
        this.zooId = id;
        this.zooName = name;
        this.location = location;
    }
    public Long getId() {
        return zooId;
    }
    public void setId(Long id) {
        this.zooId = id;
    }
    public String getName() {
        return zooName;
    }
    public void setName(String name) {
        this.zooName = name;
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
        return Objects.equals(zooId, zoo.zooId) && Objects.equals(zooName, zoo.zooName) && Objects.equals(location, zoo.location);
    }
    @Override
    public int hashCode() {
        return Objects.hash(zooId, zooName, location);
    }
    @Override
    public String toString() {
        return "Zoo{" +
                "id=" + zooId +
                ", name='" + zooName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
