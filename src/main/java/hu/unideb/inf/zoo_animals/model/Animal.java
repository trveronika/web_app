package hu.unideb.inf.zoo_animals.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="Animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long animalId;
    @Column(name="type")
    private String type;
    @Column(name="name")
    private String animalName;
    @Column(name="age")
    private int age;
    @Column(name="colour")
    private String colour;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "zoo_id")
    private Zoo zoo;

    public Animal() {
    }
    public Animal(Long id, String type, String name, int age, String colour, Zoo zoo) {
        this.animalId = id;
        this.type = type;
        this.animalName = name;
        this.age = age;
        this.colour = colour;
        this.zoo = zoo;
    }

    public Long getId() {
        return animalId;
    }

    public void setId(Long id) {
        this.animalId = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return animalName;
    }

    public void setName(String name) {
        this.animalName = name;
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
        Animal animal = (Animal) o;
        return age == animal.age && Objects.equals(animalId, animal.animalId) && Objects.equals(type, animal.type) && Objects.equals(animalName, animal.animalName) && Objects.equals(colour, animal.colour) && Objects.equals(zoo, animal.zoo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalId, type, animalName, age, colour, zoo);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + animalId +
                ", type='" + type + '\'' +
                ", name='" + animalName + '\'' +
                ", age=" + age +
                ", colour='" + colour + '\'' +
                ", zoo=" + zoo +
                '}';
    }
}
