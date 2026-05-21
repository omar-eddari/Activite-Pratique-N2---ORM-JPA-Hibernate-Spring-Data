package com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.web;

import com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.entities.Patient;
import com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;
    // relation bdirectionnelle => problem dépendant cyclique
    @GetMapping("/patients")
    public List<Patient> patients(){
        return patientRepository.findAll();
    }

}