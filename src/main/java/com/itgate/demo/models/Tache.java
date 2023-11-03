package com.itgate.demo.models;

import javax.persistence.*;

@Entity
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtache;

    private String etatche;
    private String descriptiontache;

    @ManyToOne
    @JoinColumn(name="id_societe")
    private Societe Societe;

    @ManyToOne
    @JoinColumn(name="id_offre")
    private Offre Offre;

    public Long getIdtache() {
        return idtache;
    }

    public void setIdtache(Long idtache) {
        this.idtache = idtache;
    }

    public String getEtatche() {
        return etatche;
    }

    public void setEtatche(String etatche) {
        this.etatche = etatche;
    }

    public String getDescriptiontache() {
        return descriptiontache;
    }

    public void setDescriptiontache(String descriptiontache) {
        this.descriptiontache = descriptiontache;
    }

    public Societe getSociete() { return Societe; }

    public void setSociete(Societe societe) { Societe = societe; }

    public Offre getOffre() { return Offre; }

    public void setOffre(Offre offre) { Offre = offre; }
}
