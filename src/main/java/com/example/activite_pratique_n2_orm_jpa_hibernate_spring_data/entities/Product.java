package com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data // Lombok => les getters et les setters // il va ajouter automatiquement les getters et les setters dans le bitcode
@Entity //jpa
@Data @NoArgsConstructor @AllArgsConstructor
public class Product { // entite JPA
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int quantity;

}
