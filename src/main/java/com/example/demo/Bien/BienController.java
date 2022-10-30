package com.example.demo.Bien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
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
    public void registerNewBien(@RequestBody Bien bien){
        bienService.addNewBien(bien);
    }
    @DeleteMapping(path = "{bienId}")
    public void delete(@PathVariable ("bienId") Long bienId){
        bienService.deleteBien(bienId);
    }
    @PutMapping(path = "{bienId}")
    public void put(@PathVariable("bienId") Long bienId,
                    @RequestParam(required = false) String name,
                    @RequestParam(required = false) Integer price
    ){
        bienService.updateBien( bienId, name, price);
    }

}

