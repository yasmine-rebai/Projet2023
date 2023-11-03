package com.itgate.demo.models;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idexperience;
    private String ddebut;
    private String dfinal;
    private String poste;
    private String description;
    private String entreprise;

    @ManyToOne
    @JoinColumn(name="id_candidat")
    private Candidat Candidat ;

    public Long getIdexperience() {
        return idexperience;
    }

    public void setIdexperience(Long idexperience) {
        this.idexperience = idexperience;
    }

    public String getDdebut() {
        return ddebut;
    }

    public void setDdebut(String ddebut) {
        this.ddebut = ddebut;
    }

    public String getDfinal() {
        return dfinal;
    }

    public void setDfinal(String dfinal) {
        this.dfinal = dfinal;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public Candidat getCandidat() { return Candidat; }

    public void setCandidat(Candidat candidat) { Candidat = candidat; }
}
