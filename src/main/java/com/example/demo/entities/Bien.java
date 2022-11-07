package com.example.demo.entities;

import javax.persistence.*;


@Entity
@Table(name = "Bien")
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
    @Column(
            name="bien_id",
            updatable = false
    )
    private Long id;
    @Column(
            name="title",
            nullable = false,
            columnDefinition = "TEXT"

    )
    private String title;

    @Column(
            name="address",
            nullable = false,
            columnDefinition = "TEXT"

    )
    private String address;

    @Column(
            name="description",
            nullable = false,
            columnDefinition = "TEXT"

    )
    private String description;

    @Column(
            name="price",
            nullable = false
    )

    private Integer price;

    @Column(
            name="bathroom",
            nullable = false
    )
    private Integer bathroom;

    @Column(
            name="bedroom",
            nullable = false
    )
    private Integer bedroom;

    @Column(
            name="area",
            nullable = false
    )
    private Double area;

    @Column(
            name="url",
            nullable = false,
            columnDefinition = "TEXT"

    )
    private String url;

    //J'ajoute les relations entre les entités
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id",referencedColumnName = "owner_id")
    private Owner owner;


    public Bien() {
        super();
    }
    public Bien(Long id, String title, String address, String description, Integer price, Integer bathroom, Integer bedroom, Double area, String url,Owner owner) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.description = description;
        this.price = price;
        this.bathroom = bathroom;
        this.bedroom = bedroom;
        this.area = area;
        this.url = url;
        this.owner = owner;

    }




    public Bien(String title, String address, String description, Integer price, Integer bathroom, Integer bedroom, Double area, String url, Owner owner) {
        this.title = title;
        this.address = address;
        this.description = description;
        this.price = price;
        this.bathroom = bathroom;
        this.bedroom = bedroom;
        this.area = area;
        this.url = url;
        this.owner = owner;

    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }



    @Override
    public String toString() {
        return "Bien{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", bathroom=" + bathroom +
                ", bedroom=" + bedroom +
                ", area=" + area +
                ", url='" + url + '\'' +
                "owner=" + owner +
                '}';
    }
}
