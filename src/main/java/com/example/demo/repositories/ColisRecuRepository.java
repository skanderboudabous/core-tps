package com.example.demo.repositories;

import com.example.demo.entities.ColisRecu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ColisRecuRepository extends JpaRepository<ColisRecu,String> {

    List<ColisRecu> findAllByDateAndEtat(String date, ColisRecu.EtatColiRecu etat);

    List<ColisRecu> findAllByEtat(ColisRecu.EtatColiRecu etat);
}
