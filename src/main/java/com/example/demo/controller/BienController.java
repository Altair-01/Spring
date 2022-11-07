package com.example.demo.controller;

import com.example.demo.service.BienService;
import com.example.demo.entities.Bien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Optional;

@RestController
@EnableSwagger2
//Pour angular @CrossOrigin
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/v1/bien")
public class BienController {
    private final BienService bienService;

    @Autowired
    public BienController(BienService bienService) {
        this.bienService = bienService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Bien> getBiens() {
        return bienService.getBiens();
    }

    @GetMapping("/{title}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Bien> getBienByTitle(@PathVariable("title") String title) { return bienService.getBienByTitle(title);}

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Bien> findBienById(@PathVariable("id") Long id){
        return bienService.findBienById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addBien(@RequestBody Bien bien){
        bienService.addBien(bien);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable ("id") Long id){
        bienService.deleteBien(id);
    }
    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void put(@PathVariable("id") Long id,
                    @RequestParam(required = false) String title,
                    @RequestParam(required = false) Integer price,
                    @RequestParam(required = false) String description
    ){
        bienService.updateBien( id, title,description, price);
    }

}

