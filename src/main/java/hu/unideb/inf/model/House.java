package hu.unideb.inf.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="HOUSE")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="ADDRESS", unique = true)
    private String address;
    @Column(name="PRICE")
    private int price;
    @Column(name="SIZE")
    private int size;
    @Column(name="COLOUR")
    private String colour;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OWNER_ID")
    private Person owner;

    public House() {
    }

    public House(int id, String address, int price, int size, String colour, Person owner) {
        this.id = id;
        this.address = address;
        this.price = price;
        this.size = size;
        this.colour = colour;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return id == house.id && price == house.price && size == house.size && Objects.equals(address, house.address) && Objects.equals(colour, house.colour) && Objects.equals(owner, house.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, price, size, colour, owner);
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", colour='" + colour + '\'' +
                ", owner=" + owner +
                '}';
    }
}
