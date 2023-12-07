package hu.unideb.inf.zoo_animals.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animalId")
    private Long animalId;

    @Column(name="type")
    private String type;

    @Column(name="colour")
    private String colour;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "zoo_id", nullable = false)
    private Zoo zoo;
}
