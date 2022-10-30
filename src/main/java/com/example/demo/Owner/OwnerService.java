package com.example.demo.Owner;

import com.example.demo.Bien.Bien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository){
        this.ownerRepository = ownerRepository;
    }


    public List<Owner> getOwners() {
        return ownerRepository.findAll();
    }

    //Biens
    public List<Bien> getBiensByOwner(Long id) {
        return ownerRepository.getBiensByOwner(id);
    }

    public void addNewOwner(Owner owner) {
        Optional<Owner> ownerOptional = ownerRepository.findBienByName(owner.getEmail());
        if(ownerOptional.isPresent()){
            throw new IllegalStateException("Ce proprietaire existe");
        }
        ownerRepository.save(owner);
    }
}
