package demo.controllers;

import com.example.demo.entities.ColisRecu;
import com.example.demo.repositories.ColisRecuRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/colisrecu")
@RestController()
public class ColisRecuController {

    public final ColisRecuRepository colisRecuRepository;

    public ColisRecuController(ColisRecuRepository colisRecuRepository) {
        this.colisRecuRepository = colisRecuRepository;
    }

    @GetMapping("/all")
    List<ColisRecu> all() {
        return colisRecuRepository.findAll();
    }

    @PostMapping("/add")
    ColisRecu newColisRecu(@RequestBody ColisRecu newColisRecu) {
        return colisRecuRepository.save(newColisRecu);
    }

    // Single item

    @GetMapping("/{id}")
    ColisRecu one(@PathVariable Long id) {
        if (colisRecuRepository.findById(id).isPresent()) {
            return colisRecuRepository.findById(id).get();
        }
        return null;
    }

    @PutMapping("/{id}")
    ColisRecu replaceColisRecu(@RequestBody ColisRecu newColisRecu, @PathVariable Long id) {

        return colisRecuRepository.findById(id)
                .map(colisRecu -> {
                    if (newColisRecu.getNomExp() != null)
                        colisRecu.setNomExp(newColisRecu.getNomExp());
                    if (newColisRecu.getNomDest() != null)
                        colisRecu.setNomDest(newColisRecu.getNomDest());
                    if (newColisRecu.getNbr() != null)
                        colisRecu.setNbr(newColisRecu.getNbr());
                    if (newColisRecu.getRegle() != null)
                        colisRecu.setRegle(newColisRecu.getRegle());
                    if (newColisRecu.getMontant() != null)
                        colisRecu.setMontant(newColisRecu.getMontant());
                    if (newColisRecu.getNumDest() != null)
                        colisRecu.setNumDest(newColisRecu.getNumDest());
                    if (newColisRecu.getEtat() != null)
                        colisRecu.setEtat(newColisRecu.getEtat());
                    return colisRecuRepository.save(colisRecu);
                })
                .orElseGet(() -> {
                    newColisRecu.setId(id);
                    return colisRecuRepository.save(newColisRecu);
                });
    }

    @DeleteMapping("/ColisRecus/{id}")
    void deleteColisRecu(@PathVariable Long id) {
        colisRecuRepository.deleteById(id);
    }
}
