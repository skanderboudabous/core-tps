package com.example.demo.controllers;

import com.example.demo.entities.ColisExp;
import com.example.demo.repositories.ColisExpRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/colisexp")
@RestController()
public class ColisExpController {

    public final ColisExpRepository colisExpRepository;

    public ColisExpController(ColisExpRepository colisExpRepository) {
        this.colisExpRepository = colisExpRepository;
    }

    @GetMapping("/all")
    List<ColisExp> all() {
        return colisExpRepository.findAll ();
    }

    @PostMapping("/add")
    ColisExp newColisExp(@RequestBody ColisExp newColisExp) {
        if(colisExpRepository.existsById (newColisExp.getId ()))
            return null;
        return colisExpRepository.save (newColisExp);
    }

    @PostMapping("/addAll")
    List<ColisExp> newColisExp(@RequestBody List<ColisExp> newColisExps) {
        return colisExpRepository.saveAll (newColisExps);
    }


    @GetMapping("/{id}")
    ColisExp one(@PathVariable String id) {
        if (colisExpRepository.findById (id).isPresent ())
            return colisExpRepository.findById (id).get ();
        return null;
    }

    @PutMapping("/{id}")
    ColisExp replaceColisExp(@RequestBody ColisExp newColisExp, @PathVariable String id) {
        return colisExpRepository.findById (id)
                .map (colisRecu -> {
                    if (newColisExp.getNomExp () != null)
                        colisRecu.setNomExp (newColisExp.getNomExp ());
                    if (newColisExp.getNomDest () != null)
                        colisRecu.setNomDest (newColisExp.getNomDest ());
                    if (newColisExp.getNbr () != null)
                        colisRecu.setNbr (newColisExp.getNbr ());
                    if (newColisExp.getRegle () != null)
                        colisRecu.setRegle (newColisExp.getRegle ());
                    if (newColisExp.getMontant () != null)
                        colisRecu.setMontant (newColisExp.getMontant ());
                    if (newColisExp.getDate () != null)
                        colisRecu.setDate (newColisExp.getDate ());
                    if (newColisExp.getNumDest () != null)
                        colisRecu.setNumDest (newColisExp.getNumDest ());
                    if (newColisExp.getEtat () != null)
                        colisRecu.setEtat (newColisExp.getEtat ());
                    return colisExpRepository.save (colisRecu);
                })
                .orElseGet (() -> {
                    newColisExp.setId (id);
                    return colisExpRepository.save (newColisExp);
                });
    }

    @DeleteMapping("/delete/{id}")
    void deleteColisExp(@PathVariable String id) {
        colisExpRepository.deleteById (id);
    }
}