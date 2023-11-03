package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.ICategorieRepository;
import com.itgate.demo.models.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/categorie")
public class CategorieControlleur {
    @Autowired
    public ICategorieRepository ICategorieRepository ;
    @GetMapping("/get")
    public List<Categorie> getAll(){ return ICategorieRepository.findAll();}

    @PostMapping("/save")
    public Categorie save(@RequestBody Categorie cat)
    {return ICategorieRepository.save(cat);}

    @PostMapping("/savelist")
    public List<Categorie> savelist(@RequestBody List<Categorie> Categories) {
        return ICategorieRepository.save(Categories);
    }


    @PutMapping("/update/{idcategorie}")
    public Categorie CategorieUpdate(@RequestBody Categorie cat,@PathVariable Long idcategorie)
    {cat.setIdcategorie(idcategorie);
        return ICategorieRepository.saveAndFlush(cat);
    }

    @DeleteMapping("/delete/{idcategorie}")
    public HashMap<String,String> deleteCandidature(@PathVariable Long idcategorie){
        HashMap message=new HashMap();
        try {

            ICategorieRepository.delete(idcategorie);
            message.put("status","delete");
            return message;
        }catch (Exception e) {
            message.put("status", " not found");
            return message;
        }}
}
