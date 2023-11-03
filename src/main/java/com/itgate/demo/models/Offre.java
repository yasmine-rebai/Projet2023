package com.itgate.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itgate.demo.utils.CandidatureSerializer;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idoffre;
    private String titleoffer;
    private String descriptionoffer;
    private BigDecimal salary;
    private String datelimite;
    private String profil;
    private String experience;
    private String logo;
    private String contract_type;
    private String email;
    private String duree;
    private String currency;
    private String adress;
    @Column(nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @JsonFormat(pattern ="dd-MM-yyyy")
    private Date datepost;
    private String skill;

    @ManyToOne
    @JoinColumn(name = "id_societe")
    private Societe Societe;

    @OneToMany(mappedBy = "Offre",cascade = CascadeType.ALL)
    @JsonSerialize(using = CandidatureSerializer.class)
    private List<Candidature> Candidatures;

    @OneToMany(mappedBy = "Offre",cascade = CascadeType.ALL)
    private List<JobSaved> JobSaveds;

    @OneToMany(mappedBy = "Offre",cascade = CascadeType.ALL)
    private List<Tache> Taches;

    @OneToMany(mappedBy = "Offre",cascade = CascadeType.ALL)
    private List<Commentaire> Commentaires;

    @OneToOne
    @JoinColumn(name = "id_test")
    private Test Test;



    @ManyToOne
    @JoinColumn(name = "id_city")
    private City City;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Categorie Categorie;


    public Long getIdoffre() {
        return idoffre;
    }

    public void setIdoffre(Long idoffre) {
        this.idoffre = idoffre;
    }

    public String getTitleoffer() {
        return titleoffer;
    }

    public void setTitleoffer(String titleoffer) {
        this.titleoffer = titleoffer;
    }

    public String getDescriptionoffer() {
        return descriptionoffer;
    }

    public void setDescriptionoffer(String descriptionoffer) {
        this.descriptionoffer = descriptionoffer;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getContract_type() {
        return contract_type;
    }

    public void setContract_type(String contract_type) {
        this.contract_type = contract_type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Societe getSociete() {
        return Societe;
    }

    public void setSociete(Societe societe) {
        Societe = societe;
    }

    public Categorie getCategorie() {
        return Categorie;
    }

    public void setCategorie(Categorie categorie) {
        Categorie = categorie;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getDatelimite() {
        return datelimite;
    }

    public void setDatelimite(String datelimite) {
        this.datelimite = datelimite;
    }
@JsonIgnore
    public List<Candidature> getCandidatures() {
        return Candidatures;
    }

    public void setCandidatures(List<Candidature> candidatures) {
        Candidatures = candidatures;
    }

    @JsonIgnore
    public List<JobSaved> getJobSaveds() {
        return JobSaveds;
    }

    public void setJobSaveds(List<JobSaved> jobSaveds) {
        JobSaveds = jobSaveds;
    }

    @JsonIgnore
    public List<Tache> getTaches() {
        return Taches;
    }

    public void setTaches(List<Tache> taches) {
        Taches = taches;
    }

    @JsonIgnore
    public List<Commentaire> getCommentaires() { return Commentaires; }
    public void setCommentaires(List<Commentaire> commentaires) { Commentaires = commentaires; }

    public Test getTest() {
        return Test; }
        public void setTest(Test test) { Test = test; }



    public City getCity() {
        return City;
    }

    public void setCity(City city) {
        City = city;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Date getDatepost() {
        return datepost;
    }

    public void setDatepost(Date datepost) {
        this.datepost = datepost;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
