package com.itgate.demo.models;

import javax.persistence.*;
import java.util.Date;


@Entity
public class RDV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRDV;
    private Date dateRDV;
    private String sujetRDV;
    private String etat;

    @ManyToOne
    @JoinColumn(name="id_societe")
    private Societe Societe;

    @ManyToOne
    @JoinColumn(name="id_candidat")
    private Candidat Candidat ;

    public Long getIdRDV() {
        return idRDV;
    }

    public void setIdRDV(Long idRDV) {
        this.idRDV = idRDV;
    }

    public Date getDateRDV() {
        return dateRDV;
    }

    public void setDateRDV(Date dateRDV) {
        this.dateRDV = dateRDV;
    }

    public String getSujetRDV() {
        return sujetRDV;
    }

    public void setSujetRDV(String sujetRDV) {
        this.sujetRDV = sujetRDV;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Societe getSociete() { return Societe; }

    public void setSociete(Societe societe) { Societe = societe; }

    public Candidat getCandidat() { return Candidat; }

    public void setCandidat(Candidat candidat) { Candidat = candidat; }
}

