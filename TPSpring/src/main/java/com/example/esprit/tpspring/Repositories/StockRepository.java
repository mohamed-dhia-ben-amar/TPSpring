package com.example.esprit.tpspring.Repositories;

import com.example.esprit.tpspring.Entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
