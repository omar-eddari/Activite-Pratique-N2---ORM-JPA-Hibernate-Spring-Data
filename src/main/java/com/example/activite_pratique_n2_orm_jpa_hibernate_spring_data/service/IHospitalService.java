package com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.service;


import com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.entities.Consultation;
import com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.entities.Medecin;
import com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.entities.Patient;
import com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
