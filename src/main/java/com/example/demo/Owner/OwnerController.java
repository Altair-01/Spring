package com.example.demo.Owner;

import com.example.demo.Bien.Bien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{id}/biens")
    @ResponseStatus(HttpStatus.OK)
    public List<Bien> getBiensByOwner(@PathVariable("id") Long id){
        return ownerService.getBiensByOwner(id);
    }

    @PostMapping("/addOwner")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewOwner(@RequestBody Owner owner) {
        ownerService.addNewOwner(owner);
    }

    ///IL ME FAUT FAIRE CETTE FUCKING DTO SHIT
    //@PostMapping(value = "/{ownerId}/biens/{bienId}/add")
    //@ResponseBody
    //@ResponseStatus(HttpStatus.CREATED)
    //public Owner addBienToOwner( @PathVariable final Long bienId,@PathVariable final Long ownerId){
    //    return ownerService.addBienToOwner(bienId,ownerId);

    //}

    @PutMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void put(@PathVariable("id") Long id,
                    @RequestParam(required = false) Integer telephone
    ){
        ownerService.updateOwner( id, telephone);
    }
}
