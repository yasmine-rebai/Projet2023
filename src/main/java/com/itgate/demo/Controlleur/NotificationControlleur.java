package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.INotificationRepository;
import com.itgate.demo.models.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users/notification")
public class NotificationControlleur {
    @Autowired
    public INotificationRepository INotificationRepository;

    @GetMapping("/get")
    public List<Notification> getAll() {
        return INotificationRepository.findAll();
    }

    @PostMapping("/save")
    public Notification save(@RequestBody Notification n) {
        return INotificationRepository.save(n);
    }

    @PutMapping("/update/{idnotif}")
    public Notification notificationUpdate(@RequestBody Notification n, @PathVariable Long idnotif) {
        n.setIdnotif(idnotif);
        return INotificationRepository.saveAndFlush(n);
    }

    @DeleteMapping("/delete/{idnotif}")
    public HashMap<String, String> deleteNotification(@PathVariable Long idnotif) {
        HashMap message = new HashMap();
        try {

            INotificationRepository.delete(idnotif);
            message.put("status", "delete");
            return message;
        } catch (Exception e) {
            message.put("status", " not found");
            return message;
        }
    }
}
