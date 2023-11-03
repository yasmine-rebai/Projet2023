package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.IStateRepository;
import com.itgate.demo.models.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/state")
public class StateControlleur {
    @Autowired
    public IStateRepository IStateRepository ;
    @GetMapping("/get")
    public List<State> getAll(){ return IStateRepository.findAll();}

    @GetMapping("/getone/{idstate}")
    public void get (@PathVariable Long idstate){
        State sa= IStateRepository.findOne(idstate);
        sa.setIdstate(idstate);
    }
    @PostMapping("/save")
    public State save(@RequestBody State sa)
    {return IStateRepository.save(sa);}

    @PutMapping("/update/{idstate}")
    public State stateUpdate(@RequestBody State sa,@PathVariable Long idstate)
    {sa.setIdstate(idstate);
        return IStateRepository.saveAndFlush(sa);
    }

    @DeleteMapping("/delete/{idstate}")
    public HashMap<String,String> deleteState(@PathVariable Long idstate){
        HashMap message=new HashMap();
        try {

            IStateRepository.delete(idstate);
            message.put("status","delete");
            return message;
        }catch (Exception e) {
            message.put("status", " not found");
            return message;
        }}
}
