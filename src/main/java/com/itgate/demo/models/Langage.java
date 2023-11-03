package com.itgate.demo.models;

import javax.persistence.*;

@Entity
public class Langage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idlangage;
    private String title;
    private String niveau;

    @ManyToOne
    @JoinColumn(name="id_candidat")
    private Candidat Candidat ;

    public Long getIdlangage() {
        return idlangage;
    }

    public void setIdlangage(Long idlangage) {
        this.idlangage = idlangage;
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

    public com.itgate.demo.models.Candidat getCandidat() {
        return Candidat;
    }

    public void setCandidat(com.itgate.demo.models.Candidat candidat) {
        Candidat = candidat;
    }
}
