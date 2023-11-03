package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.ICandidatRepository;
import com.itgate.demo.dao.ICompetenceRepository;
import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.Competence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/competence")
public class CompetenceControlleur {
    @Autowired
    public ICompetenceRepository ICompetenceRepository ;
    @Autowired
    public ICandidatRepository iCandidatRepository;
    @GetMapping("/get")
    public List<Competence> getAll(){ return ICompetenceRepository.findAll();}

    @PostMapping("/save")
    public Competence save(@RequestBody Competence co)
    {return ICompetenceRepository.save(co);}

    @PostMapping("/add/{id_user}")
    public Competence saveCompetence(@RequestBody Competence co,@PathVariable Long id_user) {
        Candidat Candidat = iCandidatRepository.findOne(id_user);
        co.setCandidat(Candidat);
        return ICompetenceRepository.save(co);
    }

    @PutMapping("/update/{idcompetence}/{iduser}")
    public Competence CompetenceUpdate(@RequestBody Competence co, @PathVariable Long idcompetence,@PathVariable Long iduser) {
        Competence ExistantCompetence = ICompetenceRepository.findOne(idcompetence);

        Candidat Candidat = iCandidatRepository.findOne(iduser);
        co.setCandidat(Candidat);

        ExistantCompetence.setTitle(co.getTitle());
        ExistantCompetence.setNiveau(co.getNiveau());

        return ICompetenceRepository.saveAndFlush(ExistantCompetence);
    }
    @DeleteMapping("/delete/{idcompetence}")
    public HashMap<String,String> deleteCompetence(@PathVariable Long idcompetence){
        HashMap message=new HashMap();
        try {

            ICompetenceRepository.delete(idcompetence);
            message.put("status","delete");
            return message;
        }catch (Exception e) {
            message.put("status", " not found");
            return message;
        }}
}
