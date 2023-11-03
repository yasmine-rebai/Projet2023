package com.itgate.demo.models;

import javax.persistence.*;

@Entity
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcompetence;
    private String title;
    private String niveau;

    @ManyToOne
    @JoinColumn(name="id_candidat")
    private Candidat Candidat ;

    public Long getIdcompetence() {
        return idcompetence;
    }

    public void setIdcompetence(Long idcompetence) {
        this.idcompetence = idcompetence;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public Candidat getCandidat() { return Candidat; }

    public void setCandidat(Candidat candidat) { Candidat = candidat; }
}
