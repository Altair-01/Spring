package com.example.demo.entities;

import com.example.demo.entities.Bien;

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
            name="full_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String fullName;

    @Column(
            name="username",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String username;

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


    @OneToMany(mappedBy = "owner")
    private List<Bien> biens;

    public Owner() {
    }

    public Owner(Long id, String fullName, String username, String email, String password, Integer telephone, List<Bien> biens) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.biens = biens;
    }

    public Owner( String fullName,String username, String email, String password, Integer telephone, List<Bien> biens) {
        this.fullName = fullName;
        this.username = username;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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


    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", telephone=" + telephone +
                '}';
    }
}