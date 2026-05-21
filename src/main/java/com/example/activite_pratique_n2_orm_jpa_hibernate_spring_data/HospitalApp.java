package com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data;


import com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.entities.*;
import com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.repository.*;

import com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApp {
    public static void main(String[] args) {
        SpringApplication.run(HospitalApp.class, args);
    }

    @Bean // methode qui va s'exécuter au démarrage
    CommandLineRunner start(IHospitalService hospitalService,
                            PatientRepository patientRepository,
                            MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository){//l'injection des dépendances
        return args -> {
            //patientRepository.save(new Patient(null,"Hassan",new Date(),false,null));
            Stream.of("Mohamed","Hassan","Najat").forEach(name->{
                Patient patient = new Patient();
                patient.setNom(name);
                patient.setDateNaissanec(new Date());
                patient.setMalade(false);
                hospitalService.savePatient(patient);
            });
            Stream.of("aymane","Hanane","yasmine").forEach(name->{
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setEmail(name+"@gmail.com");
                medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                hospitalService.saveMedecin(medecin);
            });

            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("Mohamed");

            Medecin medecin = medecinRepository.findByNom("yasmine");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);

            RendezVous saveRDV = hospitalService.saveRDV(rendezVous);

            System.out.println(saveRDV.getId());

            RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation....");
            hospitalService.saveConsultation( consultation);



        };
    }

}
