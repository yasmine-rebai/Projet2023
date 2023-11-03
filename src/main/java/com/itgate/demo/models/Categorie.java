package com.itgate.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcategorie;
    private String titlecategorie;

    @OneToMany(mappedBy ="Categorie",cascade = CascadeType.ALL)
    private List<Offre>Offre ;

    @OneToMany(mappedBy ="Categorie",cascade = CascadeType.ALL)
    private List<Societe>Societe ;

    public Long getIdcategorie() { return idcategorie; }

    public void setIdcategorie(Long idcategorie) { this.idcategorie = idcategorie; }

    public String getTitlecategorie() { return titlecategorie; }

    public void setTitlecategorie(String titlecategorie) { this.titlecategorie = titlecategorie; }

    @JsonIgnore
    public List<Offre> getOffre() { return Offre; }
    public void setOffre(List<Offre> offre) { Offre = offre; }

    @JsonIgnore
    public List<Societe> getSociete() { return Societe; }

    public void setSociete(List<Societe> societe) { Societe = societe; }
}
