package com.example.demo.bien;

import javax.persistence.*;


@Entity
@Table
public class Bien {
    @Id
    @SequenceGenerator(
            name = "bien_sequence",
            sequenceName = "bien_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "bien_sequence"
    )
    private Long id;
    private String name;
    private String address;
    private String description;
    private Integer price;
    private Integer bathroom;
    private Integer bedroom;
    private Double area;

    public Bien() {
    }

    public Bien(Long id,
                String name,
                String address,
                String description,
                Integer price,
                Integer bathroom,
                Integer bedroom,
                Double area) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.price = price;
        this.bathroom = bathroom;
        this.bedroom = bedroom;
        this.area = area;
    }

    public Bien(String name,
                String address,
                String description,
                Integer price,
                Integer bathroom,
                Integer bedroom,
                Double area) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.price = price;
        this.bathroom = bathroom;
        this.bedroom = bedroom;
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBathroom() {
        return bathroom;
    }

    public void setBathroom(Integer bathroom) {
        this.bathroom = bathroom;
    }

    public Integer getBedroom() {
        return bedroom;
    }

    public void setBedroom(Integer bedroom) {
        this.bedroom = bedroom;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Bien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", bathroom=" + bathroom +
                ", bedroom=" + bedroom +
                ", area=" + area +
                '}';
    }
}
