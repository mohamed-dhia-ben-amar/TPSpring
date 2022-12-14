package com.example.testfinal.Repos;

import com.example.testfinal.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    public User findByFNameAndLName(String FName, String LName);
}
