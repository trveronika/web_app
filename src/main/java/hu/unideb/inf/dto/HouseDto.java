package hu.unideb.inf.dto;

import java.util.Objects;

public class HouseDto {
    private int id;
    private String address;
    private int price;
    private int size;
    private String colour;

    public HouseDto() {
    }

    public HouseDto(int id, String address, int price, int size, String colour) {
        this.id = id;
        this.address = address;
        this.price = price;
        this.size = size;
        this.colour = colour;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseDto houseDto = (HouseDto) o;
        return id == houseDto.id && price == houseDto.price && size == houseDto.size && Objects.equals(address, houseDto.address) && Objects.equals(colour, houseDto.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, price, size, colour);
    }

    @Override
    public String toString() {
        return "HouseDto{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", size=" + size +
                ", colour='" + colour + '\'' +
                '}';
    }
}
