package com.itgate.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ideducation;
    private String datedebut;
    private String datefinale;
    private String certificat;
    private String faculte;

    @ManyToOne
    @JoinColumn(name="id_candidat")
    private Candidat Candidat ;

    public Long getIdeducation() {
        return ideducation;
    }

    public void setIdeducation(Long ideducation) {
        this.ideducation = ideducation;
    }

    public String getDatedebut() { return datedebut; }

    public void setDatedebut(String datedebut) { this.datedebut = datedebut; }

    public String getDatefinale() { return datefinale; }

    public void setDatefinale(String datefinale) { this.datefinale = datefinale; }

    public String getCertificat() {
        return certificat;
    }

    public void setCertificat(String certificat) {
        this.certificat = certificat;
    }

    public String getFaculte() {
        return faculte;
    }

    public void setFaculte(String faculte) {
        this.faculte = faculte;
    }

    public Candidat getCandidat() { return Candidat; }

    public void setCandidat(Candidat candidat) { Candidat = candidat; }
}
