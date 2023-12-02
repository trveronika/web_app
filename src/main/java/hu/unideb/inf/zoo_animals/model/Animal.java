package hu.unideb.inf.zoo_animals.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private Long animalId;
    @Column(name="type")
    private String type;
    @Column(name="age")
    private int age;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zoo_id", nullable = false)
    private Zoo zoo;

    public Animal() {
    }

    public Animal(Long animalId, String type, int age, Zoo zoo) {
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
        Animal animal = (Animal) o;
        return age == animal.age && Objects.equals(animalId, animal.animalId) && Objects.equals(type, animal.type) && Objects.equals(zoo, animal.zoo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalId, type, age, zoo);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalId=" + animalId +
                ", type='" + type + '\'' +
                ", age=" + age  +
                ", zoo=" + zoo +
                '}';
    }
}
