package com.itgate.demo.models;

import javax.persistence.*;

@Entity
public class JobSaved {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_candidat")
    private Candidat Candidat ;

    @ManyToOne
    @JoinColumn(name="id_offre")
    private Offre Offre ;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Candidat getCandidat() { return Candidat; }

    public void setCandidat(Candidat candidat) { Candidat = candidat; }

    public Offre getOffre() { return Offre; }

    public void setOffre(Offre offre) { Offre = offre; }
}
