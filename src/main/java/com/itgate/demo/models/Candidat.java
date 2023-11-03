package com.itgate.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Candidat extends User {
    private String cv ;
    private String date_naissance;
    private String gender ;
    private String LM;
    private String profil;
    private String experiencecandidat;



    @OneToMany(mappedBy ="Candidat",cascade = CascadeType.ALL)
    private List<Message> Messages;

    @OneToMany(mappedBy ="Candidat",cascade = CascadeType.ALL)
    private List<RDV> RDVs;

    @OneToMany(mappedBy ="Candidat",cascade = CascadeType.ALL)
    private List<Candidature> Candidatures;

    @OneToMany(mappedBy ="Candidat",cascade = CascadeType.ALL)
    private List<JobSaved> JobSaveds;

    @OneToMany(mappedBy ="Candidat",cascade = CascadeType.ALL)
    private List<Experience> Experiences;

    @OneToMany(mappedBy ="Candidat",cascade = CascadeType.ALL)
    private List<Competence> Competences;

    @OneToMany(mappedBy ="Candidat",cascade = CascadeType.ALL)
    private List<Education> Educations;

    @OneToMany(mappedBy ="Candidat",cascade = CascadeType.ALL)
    private List<Langage> Langages;

    @ManyToOne
    @JoinColumn(name = "id_city")
    private City city;

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getLM() { return LM; }
    public void setLM(String LM) { this.LM = LM; }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    @JsonIgnore
    public List<Message> getMessages() { return Messages; }

    public void setMessages(List<Message> messages) { Messages = messages; }

    @JsonIgnore
    public List<RDV> getRDVs() { return RDVs; }

    public void setRDVs(List<RDV> RDVs) { this.RDVs = RDVs; }

    @JsonIgnore
    public List<Candidature> getCandidatures() { return Candidatures; }

    public void setCandidatures(List<Candidature> candidatures) { Candidatures = candidatures; }

    @JsonIgnore
    public List<JobSaved> getJobSaveds() { return JobSaveds; }
    public void setJobSaveds(List<JobSaved> jobSaveds) { JobSaveds = jobSaveds; }

    @JsonIgnore
    public List<Experience> getExperiences() { return Experiences; }

    public void setExperiences(List<Experience> experiences) { Experiences = experiences; }

    @JsonIgnore
    public List<Competence> getCompetences() { return Competences; }

    public void setCompetences(List<Competence> competences) { Competences = competences; }

    @JsonIgnore
    public List<Education> getEducations() { return Educations; }

    public void setEducations(List<Education> educations) { Educations = educations; }

    @JsonIgnore
    public List<Langage> getLangages() {return Langages; }

    public void setLangages(List<Langage> langages) { Langages = langages; }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) { this.gender = gender; }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getExperiencecandidat() { return experiencecandidat; }

    public void setExperiencecandidat(String experiencecandidat) { this.experiencecandidat = experiencecandidat; }

}
