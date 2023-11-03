package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.IMessageRespository;
import com.itgate.demo.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/message")
public class MessageControlleur {
    @Autowired
    public IMessageRespository IMessageRespository;
    @GetMapping("/get")
    public List<Message> getAll(){ return IMessageRespository.findAll();}

    @PostMapping("/save")
    public Message save(@RequestBody Message m)
    {return IMessageRespository.save(m);}

    @PutMapping("/update/{idmessge}")
    public Message messageUpdate(@RequestBody Message m,@PathVariable Long idmessge)
    {m.setIdmessge(idmessge);
        return IMessageRespository.saveAndFlush(m);
    }

    @DeleteMapping("/delete/{idmessge}")
    public HashMap<String,String> deleteMessage(@PathVariable Long idmessge){
        HashMap message=new HashMap();
        try {

            IMessageRespository.delete(idmessge);
            message.put("status","delete");
            return message;
        }catch (Exception e) {
            message.put("status", " not found");
            return message;
        }}
}
