package com.springweb.app.Rest.Reinforcement.Controllers;

import com.springweb.app.Rest.Reinforcement.Models.User;
import com.springweb.app.Rest.Reinforcement.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;
    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    }
    @PostMapping(value = "/save")
    public String saveUser(User user){
        //request body Json


    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){//list of users
        return userRepo.findAll();//returns all users from the database.

    }
}
