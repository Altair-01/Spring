package com.example.demo.Image;

import com.example.demo.Bien.Bien;
import com.example.demo.Owner.Owner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Image")
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
            name="id",
            updatable = false
    )
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Lob
    @Column(name = "imagedata", length = 1000)
    private byte[] imageData;

//RELATION ENTRE IMAGE ET BIEN

}
