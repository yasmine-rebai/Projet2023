package com.itgate.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcountry;
    private String namecountry;

    @OneToMany(mappedBy = "country")
    private List<State> states;

    public Long getIdcountry() {
        return idcountry;
    }

    public void setIdcountry(Long idcountry) {
        this.idcountry = idcountry;
    }

    public String getNamecountry() {
        return namecountry;
    }

    public void setNamecountry(String namecountry) {
        this.namecountry = namecountry;
    }

    @JsonIgnore
    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }
}
