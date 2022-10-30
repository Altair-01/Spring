package com.example.demo.Bien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BienService {
    private final BienRepository bienRepository;

    @Autowired
    public BienService(BienRepository bienRepository) {
        this.bienRepository = bienRepository;
    }

    public List<Bien> getBiens() {
        return bienRepository.findAll();

    }

    public Optional<Bien> findBienById(Long id){
        return bienRepository.findBienById(id);
    }
    public void addNewBien(Bien bien) {
        Optional<Bien> bienOptional = bienRepository.findBienByName(bien.getName());
        if(bienOptional.isPresent()){
            throw new IllegalStateException("Le bien avec ce nom existe");
        }
        bienRepository.save(bien);
    }

    public void deleteBien( Long bienId){
        boolean exists = bienRepository.existsById(bienId);
        if(!exists){
            throw new IllegalStateException("Bien avec id"+bienId+"n'existe pas");
        }
        bienRepository.deleteById(bienId);
    }

    @Transactional
    public void updateBien(Long bienId, String name, Integer price) {
        Bien bien = bienRepository.findById(bienId)
                .orElseThrow(() -> new IllegalStateException("" +
                        "Ce bien avec id:"+bienId+"n'existe pas"));
        if (name!= null && name.length() > 0 && !Objects.equals(bien.getName(), name)) {
            bien.setName(name);
        }
        if (price!= null  && !Objects.equals(bien.getPrice(), price)) {
            bien.setPrice(price);
        }
    }
}
