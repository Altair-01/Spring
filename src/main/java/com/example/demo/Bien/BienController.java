package com.example.demo.Bien;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Bien> getBiens() {
        return bienService.getBiens();
    }

    @GetMapping("/{id}")
    public Optional<Bien> findBienById(@PathVariable("id") Long id){
        return bienService.findBienById(id);
    }
    @PostMapping
    public void addBien(@RequestBody Bien bien){
        bienService.addBien(bien);
    }
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable ("id") Long id){
        bienService.deleteBien(id);
    }
    @PutMapping(path = "{id}")
    public void put(@PathVariable("id") Long id,
                    @RequestParam(required = false) String title,
                    @RequestParam(required = false) Integer price
    ){
        bienService.updateBien( id, title, price);
    }

}

