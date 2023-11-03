package com.itgate.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtest;

    private String niveautest;
    private String question;
    private String resultat;

    public Long getIdtest() {
        return idtest;
    }

    public void setIdtest(Long idtest) {
        this.idtest = idtest;
    }

    public String getNiveautest() {
        return niveautest;
    }

    public void setNiveautest(String niveautest) {
        this.niveautest = niveautest;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
}
