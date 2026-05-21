package com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.service;

import com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.entities.Consultation;
import com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.entities.Medecin;
import com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.entities.Patient;
import com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.entities.RendezVous;
import com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.repository.ConsultationRepository;
import com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.repository.PatientRepository;
import com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.repository.MedecinRepository;
import com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.repository.RendezVousRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {

    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    // l'injection
    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
