package hu.unideb.inf.zoo_animals.dto;

import java.util.Objects;

public class ZooDto {
    private Long id;
    private String name;
    private String location;

    public ZooDto() {
    }

    public ZooDto(Long id, String name, String location) {
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
        ZooDto zooDto = (ZooDto) o;
        return Objects.equals(id, zooDto.id) && Objects.equals(name, zooDto.name) && Objects.equals(location, zooDto.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location);
    }

    @Override
    public String toString() {
        return "ZooDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
