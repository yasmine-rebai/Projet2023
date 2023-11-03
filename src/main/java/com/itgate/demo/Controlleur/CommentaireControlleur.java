package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.ICandidatRepository;
import com.itgate.demo.dao.ICommentaireRepository;
import com.itgate.demo.dao.IOffreRepository;
import com.itgate.demo.dao.IUser;
import com.itgate.demo.models.Candidat;
import com.itgate.demo.models.Commentaire;
import com.itgate.demo.models.Offre;
import com.itgate.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/commentaire")
public class CommentaireControlleur {
    @Autowired
    public ICommentaireRepository iCommentaireRepository;
    @Autowired
    public ICandidatRepository iCandidatRepository;
    @Autowired
    public IOffreRepository iOffreRepository;
    @Autowired
    public IUser iUser;
    @GetMapping("/get")
    public List<Commentaire> getAll(){ return iCommentaireRepository.findAll();}

    @GetMapping("/getone/{id}")
    public Commentaire getCommentaire(@PathVariable long id) {
        return iCommentaireRepository.findOne(id);
    }

    @PostMapping("/save")
    public Commentaire save(@RequestBody Commentaire co)
    {return iCommentaireRepository.save(co);}

    @PostMapping("/add/{id_user}/{id_offre}")
    public Commentaire saveCommentaire(@RequestBody Commentaire co,@PathVariable Long id_user,@PathVariable Long id_offre ) {
        User Candidat = iUser.findOne(id_user);
        co.setUser(Candidat);
        Offre offre = iOffreRepository.findOne(id_offre);
        co.setOffre(offre);
        return iCommentaireRepository.save(co);
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> deleteCommentaire(@PathVariable Long id){
        HashMap message=new HashMap();
        try {

            iCommentaireRepository.delete(id);
            message.put("status","delete");
            return message;
        }catch (Exception e) {
            message.put("status", " not found");
            return message;
        }}

}
