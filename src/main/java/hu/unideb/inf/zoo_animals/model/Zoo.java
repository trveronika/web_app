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

    public Zoo(Long zooId, String zooName, String location) {
        this.zooId = zooId;
        this.zooName = zooName;
        this.location = location;
    }

    public Long getZooId() {
        return zooId;
    }

    public void setZooId(Long zooId) {
        this.zooId = zooId;
    }

    public String getZooName() {
        return zooName;
    }

    public void setZooName(String zooName) {
        this.zooName = zooName;
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
                "zooId=" + zooId +
                ", zooName='" + zooName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
