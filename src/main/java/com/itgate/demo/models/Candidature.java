package com.itgate.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Candidature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean accepted;
    private String status;

    @Column(nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @CreatedDate
    private Date createdAt;
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
    @ManyToOne
    @JoinColumn(name = "id_candidat")
    private Candidat Candidat;
    private String score ;
    private String dateEntretien;

    private String lien;
    @ManyToOne
    @JoinColumn(name = "id_offre")
    private Offre Offre;
    @OneToMany(mappedBy = "candidature",cascade = CascadeType.ALL)
    private List<Notification> notifications;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public com.itgate.demo.models.Candidat getCandidat() {
        return Candidat;
    }

    public void setCandidat(com.itgate.demo.models.Candidat candidat) {
        Candidat = candidat;
    }

    public com.itgate.demo.models.Offre getOffre() {
        return Offre;
    }

    public void setOffre(com.itgate.demo.models.Offre offre) {
        Offre = offre;
    }

    @JsonIgnore
    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public String getDateEntretien() {
        return dateEntretien;
    }

    public void setDateEntretien(String dateEntretien) {
        this.dateEntretien = dateEntretien;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
