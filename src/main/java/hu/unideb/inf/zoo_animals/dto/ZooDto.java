package hu.unideb.inf.zoo_animals.dto;

import java.util.Objects;

public class ZooDto {
    private Long zooId;
    private String zooName;
    private String location;

    public ZooDto() {
    }

    public ZooDto(Long id, String name, String location) {
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
        ZooDto zooDto = (ZooDto) o;
        return Objects.equals(zooId, zooDto.zooId) && Objects.equals(zooName, zooDto.zooName) && Objects.equals(location, zooDto.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zooId, zooName, location);
    }

    @Override
    public String toString() {
        return "ZooDto{" +
                "id=" + zooId +
                ", name='" + zooName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
