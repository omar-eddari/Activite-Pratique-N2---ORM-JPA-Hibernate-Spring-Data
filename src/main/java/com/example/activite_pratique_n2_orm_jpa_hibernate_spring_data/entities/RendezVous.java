package com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RendezVous {
    //@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;
    @Id
    private String id;
    private Date date;
    @Enumerated(EnumType.STRING) //type enum => par defaut 0,1,2 dans BD
    private StatusRDV status; // type enum
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)// relation bdirectionnelle => problem dépendant cyclique

    private Patient patient;
    @ManyToOne
    private Medecin medecin;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
}