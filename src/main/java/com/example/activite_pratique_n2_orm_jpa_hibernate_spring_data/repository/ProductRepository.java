package com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.repository;

import com.example.activite_pratique_n2_orm_jpa_hibernate_spring_data.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> { // Spring Data
    //JpaRepository => spring data utiliser JPA forcément pour faire le mapping objet relationnel
    //CrudRepository => CRUD
    //MongoDBRepository
    // l'aventage de spring data => vous pouvez utiliser n'importe quel base de données relationnelles ou pas
    List<Product> findByNameContains(String mc);// respect la typologie des noms
    List<Product> findByPriceGreaterThan(double price);

    @Query("select p from Product p where p.name like :x")
    List<Product> search(@Param("x") String mc);

    @Query("select p from Product p where p.price>:x")
    List<Product> searchByPrice(@Param("x") double price);
}
