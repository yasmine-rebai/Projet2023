package com.itgate.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcity;
    private String city;
    private String lat;
    private String lng;
    private String country;
    private String iso2;
    private String admin_name;
    private String capital;
    private String population;
    private String population_proper;
    @OneToMany(mappedBy ="City",cascade = CascadeType.ALL)
    private List<Societe> Societes;

    @OneToMany(mappedBy = "city",cascade = CascadeType.ALL)
    private List<Candidat> candidat;

    @OneToMany(mappedBy ="City",cascade = CascadeType.ALL)
    private List<Offre> Offres;

    @ManyToOne
    @JoinColumn(name = "id_state")
    private State state;

    public Long getIdcity() { return idcity; }

    public void setIdcity(Long idcity) { this.idcity = idcity; }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getPopulation_proper() {
        return population_proper;
    }

    public void setPopulation_proper(String population_proper) {
        this.population_proper = population_proper;
    }

    @JsonIgnore
    public List<Societe> getSocietes() { return Societes; }
    public void setSocietes(List<Societe> societes) { Societes = societes; }

    @JsonIgnore
    public List<Candidat> getCandidat() { return candidat; }
    public void setCandidat(List<Candidat> candidat) { this.candidat = candidat; }

    @JsonIgnore
    public List<Offre> getOffres() { return Offres; }
    public void setOffres(List<Offre> offres) { Offres = offres; }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
