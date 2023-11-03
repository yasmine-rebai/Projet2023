package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.ICityRepository;
import com.itgate.demo.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/city")
public class CityControlleur {
    @Autowired
    public ICityRepository iCityRepository;

    @GetMapping("/get")
    public List<City> getAll() {
        return iCityRepository.findAll();
    }

    @PostMapping("/save")
    public City save(@RequestBody City ci) {
        return iCityRepository.save(ci);
    }

    @PostMapping("/savelist")
    public List<City> savelist(@RequestBody List<City> cities) {
        return iCityRepository.save(cities);
    }

    @PutMapping("/update/{idcity}")
    public City cityUpdate(@RequestBody City ci, @PathVariable Long idcity) {
        ci.setIdcity(idcity);
        return iCityRepository.saveAndFlush(ci);
    }

    @DeleteMapping("/delete/{idcity}")
    public HashMap<String, String> deleteCity(@PathVariable Long idcity) {
        HashMap message = new HashMap();
        try {

            iCityRepository.delete(idcity);
            message.put("status", "delete");
            return message;
        } catch (Exception e) {
            message.put("status", " not found");
            return message;
        }
    }

    @GetMapping("/getone/{idcity}")
    public void get(@PathVariable Long idcity) {
        City ci = iCityRepository.findOne(idcity);
        ci.getCity();
    }
}
