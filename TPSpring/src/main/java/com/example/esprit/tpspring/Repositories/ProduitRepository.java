package com.example.esprit.tpspring.Repositories;

import com.example.esprit.tpspring.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
