package com.itgate.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sujet;

    @ManyToOne
    @JoinColumn(name="id_offre")
    private Offre Offre ;

    @ManyToOne
    @JoinColumn(name="id_user")
    private User user ;
    @Column(nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd ")
    @CreatedDate
    private Date createdAt;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Offre getOffre() { return Offre; }

    public void setOffre(Offre offre) { Offre = offre; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}
