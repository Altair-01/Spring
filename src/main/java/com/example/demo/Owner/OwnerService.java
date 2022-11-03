package com.example.demo.Owner;

import com.example.demo.Bien.Bien;
import com.example.demo.Bien.BienService;
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
    public Optional<Owner> findOwnerById(Long id) {return ownerRepository.findOwnerById(id);}

    public List<Bien> getBiensByOwner(Long id) {
        return ownerRepository.getBiensByOwner(id);
    }

    public void addNewOwner(Owner owner) {
        Optional<Owner> ownerOptional = ownerRepository.findOwnerByTelephone(owner.getTelephone());
        if(ownerOptional.isPresent()){
            throw new IllegalStateException("Ce proprietaire existe");
        }
        ownerRepository.save(owner);
    }

    /*public Owner addBienToOwner(Long bienId, Long ownerId){
        Owner owner = getOwner(ownerId);
        Bien bien = bienService.getBien(bienId);
        owner.addBien(bien);
        return owner;
    }*/
    @Transactional
    public void updateOwner(Long id, Integer telephone) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("" +
                        "Ce proprietaire avec id:"+id+"n'existe pas"));

        if (telephone!= null  && !Objects.equals(owner.getTelephone(), telephone)) {
            owner.setTelephone(telephone);
        }
    }
}
