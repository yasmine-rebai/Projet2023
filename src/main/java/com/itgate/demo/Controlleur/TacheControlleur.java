package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.ITacheRepository;
import com.itgate.demo.models.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/tache")
public class TacheControlleur {
    @Autowired
    public ITacheRepository ITacheRepository;
    @GetMapping("/get")
    public List<Tache> getAll(){ return ITacheRepository.findAll();}

    @PostMapping("/save")
    public Tache save(@RequestBody Tache t)
    {return ITacheRepository.save(t);}

    @PutMapping("/update/{idtache}")
    public Tache tacheUpdate(@RequestBody Tache t,@PathVariable Long idtache)
    {t.setIdtache(idtache);
        return ITacheRepository.saveAndFlush(t);
    }

    @DeleteMapping("/delete/{idtache}")
    public HashMap<String,String> deleteTache(@PathVariable Long idtache){
        HashMap message=new HashMap();
        try {

            ITacheRepository.delete(idtache);
            message.put("status","delete");
            return message;
        }catch (Exception e) {
            message.put("status", " not found");
            return message;
        }}
}
