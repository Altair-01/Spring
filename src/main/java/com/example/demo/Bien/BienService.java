package com.example.demo.Bien;

import com.example.demo.Owner.OwnerService;
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
    public Bien getBien(Long id){
        return bienRepository.findById(id).orElseThrow(() ->
                new RuntimeException());
    }

    public Optional<Bien> findBienById(Long id){
        return bienRepository.findBienById(id);
    }
    public void addBien(Bien bien) {
        Optional<Bien> bienOptional = bienRepository.findBienByTitle(bien.getTitle());
        if(bienOptional.isPresent()){
            throw new IllegalStateException("Le bien avec ce nom existe");
        }

        if (bien.getOwner().equals(null)){
            throw new IllegalStateException("IL EST VIDE");
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
    public void updateBien(Long id, String name, Integer price) {
        Bien bien = bienRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("" +
                        "Ce bien avec id:"+id+"n'existe pas"));
        if (name!= null && name.length() > 0 && !Objects.equals(bien.getTitle(), name)) {
            bien.setTitle(name);
        }
        if (price!= null  && !Objects.equals(bien.getPrice(), price)) {
            bien.setPrice(price);
        }
    }
}
