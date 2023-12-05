package hu.unideb.inf.zoo_animals.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Zoo")
public class Zoo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zooId")
    private Long zooId;

    @Column(name="zooName", unique = true, nullable = false)

    private String zooName;

    @Column(name="location", nullable = false)
    private String location;
}
