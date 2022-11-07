package com.example.demo.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomBien", types = {Bien.class})
//Cette interface permet de récuperer les informations que nous désirons spécifiquement
public interface BienProjection {
    public String getTitle();
    public String getPrice();

}
