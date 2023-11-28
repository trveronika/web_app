package hu.unideb.inf.zoo_animals.dto;

import hu.unideb.inf.zoo_animals.model.Zoo;

import java.util.Objects;

public class AnimalDto {
    private Long animalId;
    private String type;
    private String animalName;
    private int age;
    private String colour;
    private Zoo zoo;

    public AnimalDto() {
    }

    public AnimalDto(Long animalId, String type, String animalName, int age, String colour, Zoo zoo) {
        this.animalId = animalId;
        this.type = type;
        this.animalName = animalName;
        this.age = age;
        this.colour = colour;
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

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
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
        return age == animalDto.age && Objects.equals(animalId, animalDto.animalId) && Objects.equals(type, animalDto.type) && Objects.equals(animalName, animalDto.animalName) && Objects.equals(colour, animalDto.colour) && Objects.equals(zoo, animalDto.zoo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalId, type, animalName, age, colour, zoo);
    }

    @Override
    public String toString() {
        return "AnimalDto{" +
                "animalId=" + animalId +
                ", type='" + type + '\'' +
                ", animalName='" + animalName + '\'' +
                ", age=" + age +
                ", colour='" + colour + '\'' +
                ", zoo=" + zoo +
                '}';
    }
}
