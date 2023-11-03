package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.ICandidatRepository;
import com.itgate.demo.dao.IJobSavedRepository;
import com.itgate.demo.dao.IOffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.JobSaved;
import com.itgate.demo.models.Offre;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/jobsaved")
public class JobSavedControlleur {
    @Autowired
    public IJobSavedRepository iJobSavedRepository;
    @Autowired
    public IOffreRepository iOffreRepository;
    @Autowired
    public ICandidatRepository iCandidatRepository;

    @GetMapping("/get")
    public List<JobSaved> getAll() {
        return iJobSavedRepository.findAll();
    }

    @GetMapping("/getone/{id}")
    public JobSaved get(@PathVariable Long id) {
        return iJobSavedRepository.findOne(id);
    }

    @PostMapping("/save/{id_candidat}/{id_offer}")
    public JobSaved save(JobSaved j, @PathVariable Long id_candidat, @PathVariable Long id_offer) {
        Candidat candidat = iCandidatRepository.findOne(id_candidat);
        Offre offre = iOffreRepository.findOne(id_offer);
        j.setCandidat(candidat);
        j.setOffre(offre);
        return iJobSavedRepository.save(j);
    }
    @GetMapping("/getcandidatf/{id_candidat}/{id_offre}")
    public boolean getAllC(@PathVariable Long id_candidat, @PathVariable Long id_offre) {
        List<JobSaved> listJobSaved = iJobSavedRepository.findAll();
        boolean check = false;
        Offre offre = iOffreRepository.findOne(id_offre);
        Candidat candidat = iCandidatRepository.findOne(id_candidat);
        List<JobSaved> listFinal = new ArrayList<>();
        for (JobSaved JobSaved : listJobSaved) {
            if (JobSaved.getCandidat() == candidat && JobSaved.getOffre() == offre) {
                check = true;
                break;
            }
        }
        return check;
    }

    @PutMapping("/update/{id}")
    public JobSaved candidatureUpdate(@RequestBody JobSaved j, @PathVariable Long id) {
        j.setId(id);
        return iJobSavedRepository.saveAndFlush(j);
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String, String> deleteCandidature(@PathVariable Long id) {
        HashMap message = new HashMap();
        try {

            iJobSavedRepository.delete(id);
            message.put("status", "delete");
            return message;
        } catch (Exception e) {
            message.put("status", " not found");
            return message;
        }
    }
}
