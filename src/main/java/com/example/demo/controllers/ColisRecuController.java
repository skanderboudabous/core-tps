package com.example.demo.controllers;

import com.example.demo.entities.ColisRecu;
import com.example.demo.repositories.ColisRecuRepository;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RequestMapping(value = "/colisrecu")
@RestController()
public class ColisRecuController {
    public final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public final ColisRecuRepository colisRecuRepository;

    public ColisRecuController(ColisRecuRepository colisRecuRepository) {
        this.colisRecuRepository = colisRecuRepository;
    }

    @GetMapping("/all")
    List<ColisRecu> all() {

        return colisRecuRepository.findAll ();
    }

    @PostMapping("/add")
    ColisRecu newColisRecu(@RequestBody ColisRecu newColisRecu) {
        if(colisRecuRepository.existsById (newColisRecu.getId ()))
            return null;
        return colisRecuRepository.save (newColisRecu);
    }

    @PostMapping("/addAll")
    List<ColisRecu> newColisRecu(@RequestBody List<ColisRecu> newColisRecus) {
        return colisRecuRepository.saveAll (newColisRecus);
    }
    @GetMapping("/getLastDays")
    List<List<ColisRecu>> getLastDays(){
        List<List<ColisRecu>> lastDays = new ArrayList<> ();
        List<ColisRecu> today;
        List<ColisRecu> yesterday;
        List<ColisRecu> beforeYesterday;
        LocalDate todayDate =LocalDate.now();
        LocalDate yesterdayDate =todayDate.minusDays (1);
        LocalDate beforeYesterdayDate =todayDate.minusDays (2);
        today=colisRecuRepository.findAllByDateAndEtat (dtf.format (todayDate), ColisRecu.EtatColiRecu.Attente);
        yesterday=colisRecuRepository.findAllByDateAndEtat (dtf.format (yesterdayDate),ColisRecu.EtatColiRecu.Attente);
        beforeYesterday=colisRecuRepository.findAllByDateAndEtat (dtf.format (beforeYesterdayDate),ColisRecu.EtatColiRecu.Attente);
        lastDays.add (beforeYesterday);
        lastDays.add (yesterday);
        lastDays.add (today);
        return lastDays;
    }

    @GetMapping("/{id}")
    ColisRecu one(@PathVariable String id) {
        if (colisRecuRepository.findById (id).isPresent ()) {
            return colisRecuRepository.getOne (id);
        }
        return null;
    }

    @PutMapping("/{id}")
    ColisRecu replaceColisRecu(@RequestBody ColisRecu newColisRecu, @PathVariable String id) {

        return colisRecuRepository.findById (id)
                .map (colisRecu -> {
                    if (newColisRecu.getNomExp () != null)
                        colisRecu.setNomExp (newColisRecu.getNomExp ());
                    if (newColisRecu.getNomDest () != null)
                        colisRecu.setNomDest (newColisRecu.getNomDest ());
                    if (newColisRecu.getNbr () != null)
                        colisRecu.setNbr (newColisRecu.getNbr ());
                    if (newColisRecu.getRegle () != null)
                        colisRecu.setRegle (newColisRecu.getRegle ());
                    if (newColisRecu.getMontant () != null)
                        colisRecu.setMontant (newColisRecu.getMontant ());
                    if (newColisRecu.getDate () != null)
                        colisRecu.setDate (newColisRecu.getDate ());
                    if (newColisRecu.getNumDest () != null)
                        colisRecu.setNumDest (newColisRecu.getNumDest ());
                    if (newColisRecu.getEtat () != null)
                        colisRecu.setEtat (newColisRecu.getEtat ());
                    return colisRecuRepository.save (colisRecu);
                })
                .orElseGet (() -> {
                    newColisRecu.setId (id);
                    return colisRecuRepository.save (newColisRecu);
                });
    }

    @DeleteMapping("/delete/{id}")
    void deleteColisRecu(@PathVariable String id) {
        colisRecuRepository.deleteById (id);
    }
}
