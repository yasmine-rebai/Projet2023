package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.ITestRepository;
import com.itgate.demo.models.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/test")
public class TestControlleur {
    @Autowired
    public ITestRepository ITestRepository ;
    @GetMapping("/get")
    public List<Test> getAll(){ return ITestRepository.findAll();}

    @PostMapping("/save")
    public Test save(@RequestBody Test test)
    {return ITestRepository.save(test);}

    @PutMapping("/update/{idtache}")
    public Test testUpdate(@RequestBody Test test,@PathVariable Long idtest)
    {test.setIdtest(idtest);
        return ITestRepository.saveAndFlush(test);
    }

    @DeleteMapping("/delete/{idtache}")
    public HashMap<String,String> deleteTest(@PathVariable Long idtest){
        HashMap message=new HashMap();
        try {

            ITestRepository.delete(idtest);
            message.put("status","delete");
            return message;
        }catch (Exception e) {
            message.put("status", " not found");
            return message;
        }}
}
