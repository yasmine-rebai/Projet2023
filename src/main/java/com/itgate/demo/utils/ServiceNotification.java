package com.itgate.demo.utils;

import com.itgate.demo.dao.ICandidatureRepository;
import com.itgate.demo.dao.INotificationRepository;
import com.itgate.demo.dao.IUser;
import com.itgate.demo.models.Candidature;
import com.itgate.demo.models.Notification;
import com.itgate.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceNotification {

    @Autowired
    public INotificationRepository notificationRepository;
    @Autowired
    public ICandidatureRepository candidatureRepository;

    public Notification NotifCandidatureAccept(Notification notification, Long id_candidature) {
        Candidature candidature = candidatureRepository.findOne(id_candidature);
        notification.setCandidature(candidature);
        notification.setType("Application Accepted");
        notification.setContenu("Your application for the offer " +
                candidature.getOffre().getTitleoffer() +
                " Via " + candidature.getOffre().getSociete().getCompanyname()+"is accepted"+
        " You have an interview on  :"+ candidature.getDateEntretien() + " on the link "+candidature.getLien());
        return notificationRepository.save(notification);
    }


    public Notification NotifCandidat(Notification notification, Long id_candidature) {
        Candidature candidature = candidatureRepository.findOne(id_candidature);
        notification.setContenu("You have an interview on  "
                + candidature.getOffre().getTitleoffer() +
                " Via " + candidature.getOffre().getSociete().getCompanyname());
        return notificationRepository.save(notification);
    }

}
