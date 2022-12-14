package com.example.testfinal.Repos;

import com.example.testfinal.Entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintRepo extends JpaRepository<Sprint, Integer> {
}
