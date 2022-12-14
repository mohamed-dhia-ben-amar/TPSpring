package com.example.testfinal.Services;

import com.example.testfinal.Entity.User;
import com.example.testfinal.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceIMPL implements IUserService{

    @Autowired
    UserRepo userRepo;

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }
}
