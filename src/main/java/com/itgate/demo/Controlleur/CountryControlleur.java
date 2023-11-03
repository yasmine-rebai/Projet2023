package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.ICountryRepository;
import com.itgate.demo.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/country")
public class CountryControlleur {
    @Autowired
    public ICountryRepository ICountryRepository;
    @GetMapping("/get")
    public List<Country> getAll(){ return ICountryRepository.findAll();}
    @GetMapping("/getone/{idcountry}")
    public void get (@PathVariable Long idcountry){
        Country co= ICountryRepository.findOne(idcountry);
        co.setIdcountry(idcountry);
    }
    @PostMapping("/save")
    public Country save(@RequestBody Country co)
    {return ICountryRepository.save(co);}

    @PutMapping("/update/{idcountry}")
    public Country countryUpdate(@RequestBody Country co,@PathVariable Long idcountry)
    {co.setIdcountry(idcountry);
        return ICountryRepository.saveAndFlush(co);
    }

    @DeleteMapping("/delete/{idcountry}")
    public HashMap<String,String> deleteCountry(@PathVariable Long idcountry){
        HashMap message=new HashMap();
        try {

            ICountryRepository.delete(idcountry);
            message.put("status","delete");
            return message;
        }catch (Exception e) {
            message.put("status", " not found");
            return message;
        }}
}
