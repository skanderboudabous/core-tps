package net.tps.colisexpe.controllers;


import net.tps.colisexpe.entities.ColisExp;
import net.tps.colisexpe.repositories.ColisExpRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/colisexp")
@RestController()

public class ColisExpController {

    private final ColisExpRepository colisExpRepository;

    public ColisExpController(ColisExpRepository colisExpRepository) {
        this.colisExpRepository = colisExpRepository;
    }

    @GetMapping("/expall")
    List<ColisExp> all() {
        return colisExpRepository.findAll();
    }

    @PostMapping("/expadd")
    ColisExp newColisExp(@RequestBody ColisExp newColisExp) {
        return colisExpRepository.save(newColisExp);
    }

    // Single item

    @GetMapping("/{expid}")
    ColisExp one(@PathVariable Long id) {
        if (colisExpRepository.findById(id).isPresent()) {
            return colisExpRepository.findById(id).get();
        }
        return null;
    }


    @DeleteMapping("/ColisExp/{id}")
    void deleteColisExp(@PathVariable Long id) {
        colisExpRepository.deleteById(id);
    }
}


