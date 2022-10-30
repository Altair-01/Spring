package com.example.demo.Owner;

import com.example.demo.Bien.Bien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/proprietaire")

public class OwnerController {
    private final OwnerService ownerService;


    @Autowired
    public OwnerController(OwnerService ownerService){
        this.ownerService = ownerService;
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

}
