package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.ICandidatRepository;
import com.itgate.demo.dao.ILangageRepository;
import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.Langage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/langage")
public class LangageControlleur {
    @Autowired
    public ILangageRepository iLangageRepository ;
    @Autowired
    public ICandidatRepository iCandidatRepository;

    @GetMapping("/get")
    public List<Langage> getAll(){ return iLangageRepository.findAll();}

    @PostMapping("/save")
    public Langage save(@RequestBody Langage l)
    {return iLangageRepository.save(l);}

    @PostMapping("/add/{id_user}")
    public Langage saveLangage(@RequestBody Langage l,@PathVariable Long id_user) {
        Candidat Candidat = iCandidatRepository.findOne(id_user);
        l.setCandidat(Candidat);
        return iLangageRepository.save(l);
    }

    @PutMapping("/update/{idlangage}/{iduser}")
    public Langage LangageUpdate(@RequestBody Langage l, @PathVariable Long idlangage,@PathVariable Long iduser) {
        Langage ExistantLangage = iLangageRepository.findOne(idlangage);

        Candidat Candidat = iCandidatRepository.findOne(iduser);
        l.setCandidat(Candidat);

        ExistantLangage.setTitle(l.getTitle());
        ExistantLangage.setNiveau(l.getNiveau());

        return iLangageRepository.saveAndFlush(ExistantLangage);
    }
    @DeleteMapping("/delete/{idlangage}")
    public HashMap<String,String> deleteCompetence(@PathVariable Long idlangage){
        HashMap message=new HashMap();
        try {

            iLangageRepository.delete(idlangage);
            message.put("status","delete");
            return message;
        }catch (Exception e) {
            message.put("status", " not found");
            return message;
        }}
}
