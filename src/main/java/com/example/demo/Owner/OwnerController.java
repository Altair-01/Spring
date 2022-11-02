package com.example.demo.Owner;

import com.example.demo.Bien.Bien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/proprietaire")

public class OwnerController {
    private final OwnerService ownerService;


    @Autowired
    public OwnerController(OwnerService ownerService){
        this.ownerService = ownerService;
    }

    @GetMapping("/{id}")
    public Optional<Owner> findOwnerById(@PathVariable("id") Long id){
        return ownerService.findOwnerById(id);
    }


    @GetMapping
    public List<Owner> getOwners(){
        return ownerService.getOwners();
    }

    @GetMapping("/{id}/biens")
    public List<Bien> getBiensByOwner(@PathVariable("id") Long id){
        return ownerService.getBiensByOwner(id);
    }

    @PostMapping("/addOwner")
    public void addNewOwner(@RequestBody Owner owner) {
        ownerService.addNewOwner(owner);
    }

    @PutMapping(path = "{id}")
    public void put(@PathVariable("id") Long id,
                    @RequestParam(required = false) Integer telephone
    ){
        ownerService.updateOwner( id, telephone);
    }
}
