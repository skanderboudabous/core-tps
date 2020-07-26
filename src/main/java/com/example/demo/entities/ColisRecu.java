package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
public class ColisRecu {

    @Id
    private String id;
    private String nomExp;
    private String nomDest;
    private String nbr;
    private String regle;
    private String montant;
    private String date;
    private String numDest;
    private EtatColiRecu etat = EtatColiRecu.Attente;

    public ColisRecu() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ColisRecu(String nomExp, String nomDest, String nbr, String regle, String montant, String date) {
        this.nomExp = nomExp;
        this.nomDest = nomDest;
        this.nbr = nbr;
        this.regle = regle;
        this.montant = montant;
        this.date = date;
    }

    public ColisRecu(String nomExp, String nomDest, String nbr, String regle, String montant, String date, String numDest, EtatColiRecu etat) {
        this.nomExp = nomExp;
        this.nomDest = nomDest;
        this.nbr = nbr;
        this.regle = regle;
        this.montant = montant;
        this.date = date;
        this.numDest = numDest;
        this.etat = etat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomExp() {
        return nomExp;
    }

    public void setNomExp(String nomExp) {
        this.nomExp = nomExp;
    }

    public String getNomDest() {
        return nomDest;
    }

    public void setNomDest(String nomDest) {
        this.nomDest = nomDest;
    }

    public String getNbr() {
        return nbr;
    }

    public void setNbr(String nbr) {
        this.nbr = nbr;
    }

    public String getRegle() {
        return regle;
    }

    public void setRegle(String regle) {
        this.regle = regle;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getNumDest() {
        return numDest;
    }

    public void setNumDest(String numDest) {
        this.numDest = numDest;
    }

    public EtatColiRecu getEtat() {
        return etat;
    }

    public void setEtat(EtatColiRecu etat) {
        this.etat = etat;
    }


    public enum EtatColiRecu {Attente, Validé, Echoué}
}
