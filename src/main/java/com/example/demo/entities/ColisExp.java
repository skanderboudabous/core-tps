package com.example.demo.entities;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ColisExp {

    @Id
    private String id;
    private String nomExp;
    private String nomDest;
    private String nbr;
    private String regle;
    private String montant;
    private String date;
    private String numDest;
    private EtatColisExp etat = EtatColisExp.Depose;



    public ColisExp(){}
    public ColisExp(String id,String nomExp, String nomDest, String nbr, String regle, String montant, String date) {
        this.id=id;
        this.nomExp = nomExp;
        this.nomDest = nomDest;
        this.nbr = nbr;
        this.regle = regle;
        this.montant = montant;
        this.date = date;
    }
    public ColisExp(String nomExp, String nomDest, String nbr, String regle, String montant, String date, String numDest, EtatColisExp etat) {
        this.id=id;
        this.nomExp = nomExp;
        this.nomDest = nomDest;
        this.nbr = nbr;
        this.regle = regle;
        this.montant = montant;
        this.date = date;
        this.numDest = numDest;
        this.etat = etat;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public ColisExp.EtatColisExp getEtat() {
        return etat;
    }

    public void setEtat(ColisExp.EtatColisExp etat) {
        this.etat = etat;
    }

    public enum EtatColisExp {Depose, charge}
}
