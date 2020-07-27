package com.example.demo.repositories;

import com.example.demo.entities.ColisRecu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColisRecuRepository extends JpaRepository<ColisRecu,String> {

    List<ColisRecu> findAllByDateAndEtat(String date, ColisRecu.EtatColiRecu etat);

    List<ColisRecu> findAllByEtat(ColisRecu.EtatColiRecu etat);
}
