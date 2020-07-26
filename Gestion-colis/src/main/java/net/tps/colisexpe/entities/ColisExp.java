package net.tps.colisexpe.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ColisExp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomExp;
    private String nomDest;
    private String nbr;
    private String regle;
    private Double montant;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    private String numDest;
    private ColisExp.EtatColisExp etatExp = ColisExp.EtatColisExp.Depose;


    public ColisExp() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public ColisExp(String nomExp, String nomDest, String nbr, String regle, Double montant, Date date, String numDest, ColisExp.EtatColisExp etatExp) {
        this.nomExp = nomExp;
        this.nomDest = nomDest;
        this.nbr = nbr;
        this.regle = regle;
        this.montant = montant;
        this.date = date;
        this.numDest = numDest;
        this.etatExp = etatExp;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getNumDest() {
        return numDest;
    }

    public void setNumDest(String numDest) {
        this.numDest = numDest;
    }

    public ColisExp.EtatColisExp getEtatExp() {
        return etatExp;
    }

    public void setEtatExp(ColisExp.EtatColisExp etatExp) {
        this.etatExp = etatExp;
    }

    public enum EtatColisExp {Depose, charge}
}

