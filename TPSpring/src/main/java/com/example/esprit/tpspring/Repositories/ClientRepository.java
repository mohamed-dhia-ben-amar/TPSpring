package com.example.esprit.tpspring.Repositories;

import com.example.esprit.tpspring.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
