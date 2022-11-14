package com.example.demo.service;

import com.example.demo.entities.Bien;
import com.example.demo.entities.Owner;
import com.example.demo.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;
    private final BienService bienService;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository, BienService bienService){
        this.ownerRepository = ownerRepository;
        this.bienService = bienService;
    }

    public List<Owner> getOwners() {
        return StreamSupport.stream(ownerRepository.findAll()
                .spliterator(), false)
                .collect(Collectors.toList());
    }

    public Owner getOwner(Long id){
        return ownerRepository.findById(id).orElseThrow(() ->
                new RuntimeException());
    }
    //Biens
    public Optional<Owner> findOwnerByName(String fullName) {return ownerRepository.findOwnerByName(fullName);}
    public Optional<Owner> findOwnerByUsername(String username) {return ownerRepository.findOwnerByUsername(username);}


    public Optional<Owner> findOwnerById(Long id) {return ownerRepository.findOwnerById(id);}

    public List<Bien> getBiensByOwner(Long id) {
        return ownerRepository.getBiensByOwner(id);
    }

    public Owner addNewOwner(Owner owner) {
        Optional<Owner> ownerOptional = ownerRepository.findOwnerByUsername(owner.getUsername());
        if(ownerOptional.isPresent()){
            throw new IllegalStateException("Ce nom d'utilisateur existe déjà");
        }
        return ownerRepository.save(owner);

    }

    /*public Owner addBienToOwner(Long bienId, Long ownerId){
        Owner owner = getOwner(ownerId);
        Bien bien = bienService.getBien(bienId);
        owner.addBien(bien);
        return owner;
    }*/
    public void deleteOwner(Long ownerId){
        boolean exists = ownerRepository.existsById(ownerId);
        if(!exists){
            throw new IllegalStateException("Bien avec id"+ownerId+"n'existe pas");
        }
        ownerRepository.deleteById(ownerId);}

    @Transactional
    public void updateOwner(Long id, Integer telephone, String email, String password) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("" +
                        "Ce proprietaire avec id:"+id+"n'existe pas"));

        if (telephone!= null  && !Objects.equals(owner.getTelephone(), telephone)) {
            owner.setTelephone(telephone);
        }
        if (email!= null && email.length() > 0 && !Objects.equals(owner.getEmail(), email)) {
            owner.setEmail(email);
        }
        if (password!= null && password.length() > 0 && !Objects.equals(owner.getPassword(), password)) {
            owner.setPassword(password);
        }
    }
}
