package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.ICandidatRepository;
import com.itgate.demo.dao.IExperienceRepository;
import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/experience")
public class ExperienceControlleur {
    @Autowired
    public IExperienceRepository iExperienceRepository;
    @Autowired
    public ICandidatRepository iCandidatRepository;

    @GetMapping("/get")
    public List<Experience> getAll(){ return iExperienceRepository.findAll();}

    @GetMapping("/getone/{idexperience}")
    public Experience getExperience(@PathVariable long idexperience) {
        return iExperienceRepository.findOne(idexperience);
    }

    @PostMapping("/save")
    public Experience save(@RequestBody Experience ex)
    {return iExperienceRepository.save(ex);}

    @PostMapping("/add/{id_user}")
    public Experience saveExperience(@RequestBody Experience ex,@PathVariable Long id_user) {
        Candidat Candidat = iCandidatRepository.findOne(id_user);
        ex.setCandidat(Candidat);
        return iExperienceRepository.save(ex);
    }

    @PutMapping("/update/{idexperience}/{iduser}")
    public Experience ExperienceUpdate(@RequestBody Experience ex, @PathVariable Long idexperience,@PathVariable Long iduser) {
        Experience ExistantExperience = iExperienceRepository.findOne(idexperience);

        Candidat Candidat = iCandidatRepository.findOne(iduser);
        ex.setCandidat(Candidat);

        ExistantExperience.setEntreprise(ex.getEntreprise());
        ExistantExperience.setDdebut(ex.getDdebut());
        ExistantExperience.setDfinal(ex.getDfinal());
        ExistantExperience.setPoste(ex.getPoste());
        ExistantExperience.setDescription(ex.getDescription());
        return iExperienceRepository.saveAndFlush(ExistantExperience);
    }

    @DeleteMapping("/delete/{idexperience}")
    public HashMap<String,String> deleteexperiencee(@PathVariable Long idexperience){
        HashMap message=new HashMap();
        try {

            iExperienceRepository.delete(idexperience);
            message.put("status","delete");
            return message;
        }catch (Exception e) {
            message.put("status", " not found");
            return message;
        }}
}
