package com.example.demo.repositories;

import com.example.demo.entities.ColisRecu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ColisRecuRepository extends JpaRepository<ColisRecu, String> {

    public List<ColisRecu> findAllByDate(String date);

    public List<ColisRecu> findAllByNumDest(String numDest);
}
