package com.itgate.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idstate;
    private String namestate;

    @OneToMany(mappedBy = "state")
    private List<City> city;

   @ManyToOne
   @JoinColumn(name = "id_country")
   private Country country;

    public Long getIdstate() { return idstate; }

    public void setIdstate(Long idstate) { this.idstate = idstate; }

    public String getNamestate() { return namestate; }

    public void setNamestate(String namestate) { this.namestate = namestate; }
    @JsonIgnore
    public List<City> getCity() { return city; }

    public void setCity(List<City> city) { this.city = city; }

    public Country getCountry() { return country; }

    public void setCountry(Country country) { this.country = country; }
}
