package com.springweb.app.Rest.Reinforcement.Controllers;

import com.springweb.app.Rest.Reinforcement.Models.User;
import com.springweb.app.Rest.Reinforcement.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();

    }
}
