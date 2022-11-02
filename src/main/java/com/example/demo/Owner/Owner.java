package com.example.demo.Owner;

import com.example.demo.Bien.Bien;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Owner",
uniqueConstraints = {
        @UniqueConstraint(name = "owner_number_unique", columnNames = "telephone")
})
public class Owner {


    @Id
    @SequenceGenerator(
            name = "owner_sequence",
            sequenceName = "owner_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "owner_sequence"
    )
    @Column(
            name="owner_id",
            updatable = false
    )
    private Long id;
    @Column(
            name="first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;
    @Column(
            name="last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;
    @Column(
            name="email",
            nullable = false
    )
    private String email;
    @Column(
            name="password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;
    @Column(
            name="telephone",
            nullable = false
    )
    private Integer telephone;


    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Bien> biens;

    public Owner() {
    }

    public Owner(Long id, String firstName, String lastName, String email, String password, Integer telephone, List<Bien> biens) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.biens = biens;
    }
    public Owner( String firstName, String lastName, String email, String password, Integer telephone, List<Bien> biens) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.biens = biens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public List<Bien> getBiens() {
        return biens;
    }

    public void setBiens(List<Bien> biens) {
        this.biens = biens;
    }

    public void addBien(Bien bien){
        biens.add(bien);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", telephone=" + telephone +
                ", biens=" + biens +
                '}';
    }
}