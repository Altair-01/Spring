package com.example.demo.bien;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BienConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            BienRepository repository){
        return args -> {
           Bien maison1 =  new Bien (
                    "Maison en bord de mer",
                    "Saly Portudal",
                    "Jolie maison en bord de mer",
                    300000,
                    3,
                    4,
                    300.0,
                   "http://url.com"
            );
            Bien maison2 =  new Bien (
                    "Maison en bord de mer",
                    "Dakar Portudal",
                    "Jolie maison en bord de mer",
                    300000,
                    3,
                    4,
                    300.0,
                    "http://url.com"
            );
            repository.saveAll(
                    List.of(maison1,maison2)
            );
        };
    }
}
