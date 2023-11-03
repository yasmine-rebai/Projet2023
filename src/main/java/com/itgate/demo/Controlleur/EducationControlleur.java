package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.ICandidatRepository;
import com.itgate.demo.dao.IEducationRepository;
import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/education")
public class EducationControlleur {
    @Autowired
    public IEducationRepository IEducationRepository ;
    @Autowired
    public ICandidatRepository iCandidatRepository;


    @GetMapping("/get")
    public List<Education> getAll(){ return IEducationRepository.findAll();}

    @GetMapping("/getone/{ideducation}")
    public Education getEducation(@PathVariable long ideducation) {
        return IEducationRepository.findOne(ideducation);
    }

    @PostMapping("/save")
    public Education save(@RequestBody Education ed)
    {return IEducationRepository.save(ed);}

    @PostMapping("/add/{id_user}")
    public Education saveEducation(@RequestBody Education ed,@PathVariable Long id_user) {
        Candidat Candidat = iCandidatRepository.findOne(id_user);
        ed.setCandidat(Candidat);
        return IEducationRepository.save(ed);
    }

    @PutMapping("/update/{ideducation}/{iduser}")
    public Education EducationUpdate(@RequestBody Education ed, @PathVariable Long ideducation,@PathVariable Long iduser) {
        Education ExistantEducation = IEducationRepository.findOne(ideducation);

        Candidat Candidat = iCandidatRepository.findOne(iduser);
        ed.setCandidat(Candidat);

        ExistantEducation.setCertificat(ed.getCertificat());
        ExistantEducation.setDatedebut(ed.getDatedebut());
        ExistantEducation.setDatefinale(ed.getDatefinale());
        ExistantEducation.setFaculte(ed.getFaculte());
        return IEducationRepository.saveAndFlush(ExistantEducation);
    }

    @DeleteMapping("/delete/{ideducation}")
    public HashMap<String,String> deleteEducation(@PathVariable Long ideducation){
        HashMap message=new HashMap();
        try {

            IEducationRepository.delete(ideducation);
            message.put("status","delete");
            return message;
        }catch (Exception e) {
            message.put("status", " not found");
            return message;
        }}
}
