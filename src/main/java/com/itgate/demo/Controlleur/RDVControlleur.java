package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.IRDVRepository;
import com.itgate.demo.models.RDV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/RDV")
public class RDVControlleur {
    @Autowired
    public IRDVRepository IRDVRepository;
    @GetMapping("/get")
    public List<RDV> getAll(){ return IRDVRepository.findAll();}

    @PostMapping("/save")
    public RDV save(@RequestBody RDV R)
    {return IRDVRepository.save(R);}

    @PutMapping("/update/{idRDV}")
    public RDV rdvUpdate(@RequestBody RDV R,@PathVariable Long idRDV)
    {R.setIdRDV(idRDV);
        return IRDVRepository.saveAndFlush(R);
    }

    @DeleteMapping("/delete/{idRDV}")
    public HashMap<String,String> deleteRDV(@PathVariable Long idRDV){
        HashMap message=new HashMap();
        try {

            IRDVRepository.delete(idRDV);
            message.put("status","delete");
            return message;
        }catch (Exception e) {
            message.put("status", " not found");
            return message;
        }}
}
