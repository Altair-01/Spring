package com.example.demo.controller;

import com.example.demo.service.OwnerService;
import com.example.demo.entities.Bien;
import com.example.demo.entities.Owner;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ResponseStatus(HttpStatus.OK)
    public Optional<Owner> findOwnerById(@PathVariable("id") Long id){
        return ownerService.findOwnerById(id);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Owner> getOwners(){
        return ownerService.getOwners();
    }

    @GetMapping("{fullName}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Owner> findOwnerByName(@PathVariable("fullName") String fullName){ return ownerService.findOwnerByName(fullName);}

    @GetMapping("{username}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Owner> findOwnerByUsername(@PathVariable("username") String username){ return ownerService.findOwnerByUsername(username);}

    @GetMapping("/{id}/biens")
    @ResponseStatus(HttpStatus.OK)
    public List<Bien> getBiensByOwner(@PathVariable("id") Long id){
        return ownerService.getBiensByOwner(id);
    }

    @PostMapping("/addOwner")
    public ResponseEntity<Owner> addNewOwner(@RequestBody Owner owner) {
       return ResponseEntity.ok().body(ownerService.addNewOwner(owner));
    }

    ///IL ME FAUT FAIRE CETTE FUCKING DTO SHIT
    //@PostMapping(value = "/{ownerId}/biens/{bienId}/add")
    //@ResponseBody
    //@ResponseStatus(HttpStatus.CREATED)
    //public Owner addBienToOwner( @PathVariable final Long bienId,@PathVariable final Long ownerId){
    //    return ownerService.addBienToOwner(bienId,ownerId);

    //}
    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id){
        ownerService.deleteOwner(id);
    }

    @PutMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void put(@PathVariable("id") Long id,
                    @RequestParam(required = false) Integer telephone,
                    @RequestParam(required = false) String email,
                    @RequestParam(required = false) String password
    ){
        ownerService.updateOwner( id, telephone, email, password);
    }
}
