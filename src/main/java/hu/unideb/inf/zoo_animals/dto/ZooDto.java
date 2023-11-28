package hu.unideb.inf.zoo_animals.dto;

import java.util.Objects;

public class ZooDto {
    private Long zooId;
    private String zooName;
    private String location;

    public ZooDto() {
    }

    public ZooDto(Long zooId, String zooName, String location) {
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
                "zooId=" + zooId +
                ", zooName='" + zooName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
