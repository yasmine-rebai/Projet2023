package com.itgate.demo.models;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmessge;
    private Date datemessage;
    private String sujetmessage;

    @ManyToOne
    @JoinColumn(name="id_societe")
    private Societe Societe;

    @ManyToOne
    @JoinColumn(name="id_candidat")
    private Candidat Candidat ;


    public Long getIdmessge() {
        return idmessge;
    }

    public void setIdmessge(Long idmessge) {
        this.idmessge = idmessge;
    }

    public Date getDatemessage() {
        return datemessage; }

    public void setDatemessage(Date datemessage) {
        this.datemessage = datemessage;
    }

    public String getSujetmessage() {
        return sujetmessage;
    }

    public void setSujetmessage(String sujetmessage) {
        this.sujetmessage = sujetmessage;
    }


    public Societe getSociete() { return Societe; }
    public void setSociete(Societe societe) { Societe = societe; }

    public Candidat getCandidat() { return Candidat; }

    public void setCandidat(Candidat candidat) { Candidat = candidat; }
}
