package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.ICategorieRepository;
import com.itgate.demo.dao.ICityRepository;
import com.itgate.demo.dao.IOffreRepository;
import com.itgate.demo.dao.ISocieteRepository;
import com.itgate.demo.models.Categorie;
import com.itgate.demo.models.City;
import com.itgate.demo.models.Offre;
import com.itgate.demo.models.Societe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/offre")
public class OffreControlleur {
    private final Path rootLocation = Paths.get("upload-dir");
    @Autowired
    public IOffreRepository iOffreRepository;
    @Autowired
    public ISocieteRepository iSocieteRepository;
    @Autowired
    public ICategorieRepository iCategorieRepository;
    @Autowired
    public ICityRepository iCityRepository;
    @GetMapping("/get")
    public List<Offre> getAll() {
        return iOffreRepository.findAll();
    }

    @GetMapping("/getone/{idoffer}")
    public Offre getoffer(@PathVariable long idoffer) {
        return iOffreRepository.findOne(idoffer);
    }

    @PostMapping("/save")
    public Offre save(@RequestBody Offre o) {
        return iOffreRepository.save(o);
    }


    @PostMapping("/add/{id_societe}/{id_category}/{id_city}")
    public Offre saveOffre(Offre o, @RequestParam("file")MultipartFile file,@PathVariable Long id_societe,@PathVariable Long id_city,@PathVariable Long id_category) {
        Societe societe = iSocieteRepository.findOne(id_societe);
        o.setSociete(societe);
        Categorie categorie=iCategorieRepository.findOne(id_category);
        o.setCategorie(categorie);
        City city=iCityRepository.findOne(id_city);
        o.setCity(city);
        try {

            String fileName = Integer.toString(new Random().nextInt(1000000000));
            String ext = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf('.'), file.getOriginalFilename().length());
            String name = file.getOriginalFilename().substring(0, file.getOriginalFilename().indexOf('.'));
            String original = name + fileName + ext;
            Files.copy(file.getInputStream(), this.rootLocation.resolve(original));
            o.setLogo(original);

        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
        return iOffreRepository.save(o);
    }

    @PutMapping("/updateimage/{idoffre}")
    public Offre updateOffreLogo(@RequestParam("file") MultipartFile file, Offre o, @PathVariable Long idoffre) {
        Offre Existantoffre = iOffreRepository.findOne(idoffre);
        try {
            String fileName = Integer.toString(new Random().nextInt(1000000000));
            String ext = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf('.'), file.getOriginalFilename().length());
            String name = file.getOriginalFilename().substring(0, file.getOriginalFilename().indexOf('.'));
            String original = name + fileName + ext;
            Files.copy(file.getInputStream(), this.rootLocation.resolve(original));
            Existantoffre.setLogo(original);

        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
        return iOffreRepository.saveAndFlush(Existantoffre);
    }

    @PutMapping("/update/{idoffre}")
    public Offre offreUpdate(@RequestBody Offre o, @PathVariable Long idoffre) {
        Offre ExistantOffre = iOffreRepository.findOne(idoffre);
        ExistantOffre.setTitleoffer(o.getTitleoffer());
        ExistantOffre.setEmail(o.getEmail());
        ExistantOffre.setDatelimite(o.getDatelimite());
        ExistantOffre.setDuree(o.getDuree());
        ExistantOffre.setCategorie(o.getCategorie());
        ExistantOffre.setContract_type(o.getContract_type());
        ExistantOffre.setSalary(o.getSalary());
        ExistantOffre.setCurrency(o.getCurrency());
        ExistantOffre.setExperience(o.getExperience());
        ExistantOffre.setProfil(o.getProfil());
        ExistantOffre.setSkill(o.getSkill());
        return iOffreRepository.saveAndFlush(ExistantOffre);
    }

    @DeleteMapping("/delete/{idoffre}")
    public HashMap<String, String> deleteOffre(@PathVariable Long idoffre) {
        HashMap message = new HashMap();
        try {

            iOffreRepository.delete(idoffre);
            message.put("status", "delete");
            return message;
        } catch (Exception e) {
            message.put("status", " not found");
            return message;
        }
    }
}
