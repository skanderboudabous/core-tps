package com.example.demo.config;

import com.example.demo.entities.ColisRecu;
import com.example.demo.repositories.ColisRecuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class SchedulingConfiguration {
    public final ColisRecuRepository colisRecuRepository;

    private final long DAY = 2073600000;
    private final long HOUR = 86400000;

    private final long MINUTE = 60000;

    private final long SECOND = 1000;

    public SchedulingConfiguration(ColisRecuRepository colisRecuRepository) {
        this.colisRecuRepository = colisRecuRepository;
    }


    @Scheduled(fixedRate = DAY)
    public void reportCurrentTime() {
        List<ColisRecu> attente = this.colisRecuRepository.findAllByEtat (ColisRecu.EtatColiRecu.Attente);
        LocalDate now=new Date().toInstant ().atZone (ZoneId.systemDefault ()).toLocalDate ();
        for (ColisRecu colisRecu :
                attente) {
            Date colisDate = new Date ();
            String[] dateValues = colisRecu.getDate ().split ("-");
            colisDate.setDate (Integer.parseInt (dateValues[0]));
            colisDate.setMonth (Integer.parseInt (dateValues[1]) - 1);
            colisDate.setYear (Integer.parseInt (dateValues[2])-1900);
            LocalDate colisLocalDate=colisDate.toInstant ().atZone (ZoneId.systemDefault ()).toLocalDate ();
            int diffInDays=Period.between (colisLocalDate,now).getDays ();
            if (diffInDays >= 3) {
                colisRecu.setEtat (ColisRecu.EtatColiRecu.Echoué);
                this.colisRecuRepository.save (colisRecu);
            }
        }
    }
}