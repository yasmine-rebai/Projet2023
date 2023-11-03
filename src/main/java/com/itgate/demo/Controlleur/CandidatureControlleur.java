package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.ICandidatRepository;
import com.itgate.demo.dao.ICandidatureRepository;
import com.itgate.demo.dao.IOffreRepository;
import com.itgate.demo.dao.ISocieteRepository;
import com.itgate.demo.models.*;
import com.itgate.demo.utils.ServiceNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/candidature")
public class CandidatureControlleur {
    @Autowired
    public ICandidatureRepository icandidatureRepository;
    @Autowired
    public IOffreRepository iOffreRepository;
    @Autowired
    public ICandidatRepository iCandidatRepository;
    @Autowired
    public ISocieteRepository iSocieteRepository;
    @Autowired
    public ServiceNotification serviceNotification;
    @GetMapping("/get")
    public List<Candidature> getAll() {
        return icandidatureRepository.findAll();
    }

    @GetMapping("/getcandidat/{id_candidat}")
    public List<Candidature> getAllC(@PathVariable Long id_candidat) {
        List<Candidature> listCandidatures = icandidatureRepository.findAll();
        Candidat candidat = iCandidatRepository.findOne(id_candidat);
        List<Candidature> listFinal = new ArrayList<>();
        for (Candidature candidature : listCandidatures) {
            if (candidature.getCandidat() == candidat) {
                listFinal.add(candidature);
            }
        }
        return listFinal;
    }

    @GetMapping("/getcsociete/{id_societe}")
    public List<Candidature> getAllCSociete(@PathVariable Long id_societe) {
        List<Candidature> listCandidatures = icandidatureRepository.findAll();
        Societe societe = iSocieteRepository.findOne(id_societe);
        List<Candidature> listFinal = new ArrayList<>();
        for (Candidature candidature : listCandidatures) {
            if (candidature.getOffre().getSociete() == societe) {
                listFinal.add(candidature);}
        }
        return listFinal;
    }

    @GetMapping("/getoffre/{id_offre}")
    public List<Candidature> getAllO(@PathVariable Long id_offre) {
        List<Candidature> listCandidatures = icandidatureRepository.findAll();
        Offre offre = iOffreRepository.findOne(id_offre);
        List<Candidature> listFinal = new ArrayList<>();
        for (Candidature candidature : listCandidatures) {
            if (candidature.getOffre() == offre) {
                listFinal.add(candidature);
            }
        }
        return listFinal;
    }

    @GetMapping("/getone/{idcandidature}")
    public Candidature get(@PathVariable Long idcandidature) {
        return icandidatureRepository.findOne(idcandidature);
    }

    @PostMapping("/save/{id_candidat}/{id_offer}")
    public Candidature save(@RequestBody Candidature ca, @PathVariable Long id_candidat, @PathVariable Long id_offer) {
        Candidat candidat = iCandidatRepository.findOne(id_candidat);
        Offre offre = iOffreRepository.findOne(id_offer);
        ca.setCandidat(candidat);
        ca.setOffre(offre);
        ca.setAccepted(false);
        ca.setStatus("Non vue");
        return icandidatureRepository.save(ca);
    }

    @PutMapping("/update/{id}")
    public Candidature candidatureUpdate(@RequestBody Candidature ca, @PathVariable Long id) {
        ca.setId(id);
        return icandidatureRepository.saveAndFlush(ca);
    }

    @PutMapping("/accept/{id}")
    public Candidature Accept(@RequestBody Candidature c ,@PathVariable Long id, Notification notification) {
        Candidature candidature = icandidatureRepository.findOne(id);
        candidature.setDateEntretien(c.getDateEntretien());
        candidature.setLien(c.getLien());
        candidature.setAccepted(true);
        candidature.setStatus("Accepted");
        serviceNotification.NotifCandidatureAccept(notification,id);
        return icandidatureRepository.saveAndFlush(candidature);
    }
    @PutMapping("/reject/{id}")
    public Candidature Reject(@PathVariable Long id) {
        Candidature candidature = icandidatureRepository.findOne(id);
        candidature.setStatus("Rejected");
        return icandidatureRepository.saveAndFlush(candidature);
    }

    @DeleteMapping("/delete/{idcandidature}")
    public HashMap<String, String> deleteCandidature(@PathVariable Long idcandidature) {
        HashMap message = new HashMap();
        try {

            icandidatureRepository.delete(idcandidature);
            message.put("status", "delete");
            return message;
        } catch (Exception e) {
            message.put("status", " not found");
            return message;
        }
    }
}
