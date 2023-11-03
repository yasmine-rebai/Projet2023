package com.itgate.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Societe extends User {

    private String Companyname;
    private String since;
    private String domaine;
    private String siteweb;

    @OneToMany(mappedBy ="Societe",cascade = CascadeType.ALL)
    private List<RDV> RDVs;

    @OneToMany(mappedBy ="Societe",cascade = CascadeType.ALL)
    private List<Tache> Taches;

    @OneToMany(mappedBy ="Societe",cascade = CascadeType.ALL)
   private List<Message> messages;

    @OneToMany(mappedBy ="Societe",cascade = CascadeType.ALL)
    private List<Offre> Offres;

    @ManyToOne
    @JoinColumn(name="id_city")
    private City City ;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Categorie Categorie;




    public String getDomaine() { return domaine; }

    public void setDomaine(String domaine) { this.domaine = domaine; }


    public String getSiteweb() { return siteweb; }

    public void setSiteweb(String siteweb) { this.siteweb = siteweb; }

    @JsonIgnore
    public List<RDV> getRDVs() { return RDVs; }
    public void setRDVs(List<RDV> RDVs) { this.RDVs = RDVs; }

    @JsonIgnore
    public List<Tache> getTaches() { return Taches; }
    public void setTaches(List<Tache> taches) { Taches = taches; }

    @JsonIgnore
    public List<Message> getMessages() { return messages; }
    public void setMessages(List<Message> messages) { this.messages = messages; }

    @JsonIgnore
    public List<Offre> getOffres() { return Offres; }
    public void setOffres(List<Offre> offres) { Offres = offres; }

    public City getCity() { return City; }
    public void setCity(City city) { City = city; }
    public Categorie getCategorie() { return Categorie; }
    public void setCategorie(Categorie categorie) { Categorie = categorie; }

    public String getCompanyname() {
        return Companyname;
    }

    public void setCompanyname(String companyname) {
        Companyname = companyname;
    }

    public String getSince() { return since; }
    public void setSince(String since) { this.since = since; }
}
