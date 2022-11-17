package com.example.esprit.tpspring.Repositories;

import com.example.esprit.tpspring.Entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactureRepository extends JpaRepository<Facture, Long> {
    List<Facture> getFactureByClientIdClient(Long idClient);
}
