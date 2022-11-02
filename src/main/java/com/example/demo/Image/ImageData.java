package com.example.demo.Image;

import com.example.demo.Bien.Bien;
import com.example.demo.Owner.Owner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ImageData")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageData {
    @Id
    @SequenceGenerator(
            name = "image_sequence",
            sequenceName = "image_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "image_sequence"
    )
    @Column(
            name="image_id",
            updatable = false
    )
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Lob
    @Column(name = "imageData", length = 1000)
    private byte[] imageData;

//RELATION ENTRE IMAGE ET BIEN
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bien_id",referencedColumnName = "bien_id")

    private Bien bien;
}
