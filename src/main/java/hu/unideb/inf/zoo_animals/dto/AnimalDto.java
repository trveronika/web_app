package hu.unideb.inf.zoo_animals.dto;

import hu.unideb.inf.zoo_animals.model.Zoo;

import java.util.Objects;

public class AnimalDto {
    private Long animalId;
    private String type;
    private int age;
    private Zoo zoo;

    public AnimalDto() {
    }

    public AnimalDto(Long animalId, String type, int age, Zoo zoo) {
        this.animalId = animalId;
        this.type = type;
        this.age = age;
        this.zoo = zoo;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalDto animalDto = (AnimalDto) o;
        return age == animalDto.age && Objects.equals(animalId, animalDto.animalId) && Objects.equals(type, animalDto.type) && Objects.equals(zoo, animalDto.zoo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalId, type, age, zoo);
    }

    @Override
    public String toString() {
        return "AnimalDto{" +
                "animalId=" + animalId +
                ", type='" + type + '\'' +
                ", age=" + age +
                ", zoo=" + zoo +
                '}';
    }
}
