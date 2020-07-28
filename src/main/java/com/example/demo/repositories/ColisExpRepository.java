package com.example.demo.repositories;

import com.example.demo.entities.ColisExp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColisExpRepository extends JpaRepository<ColisExp,String> {
}
