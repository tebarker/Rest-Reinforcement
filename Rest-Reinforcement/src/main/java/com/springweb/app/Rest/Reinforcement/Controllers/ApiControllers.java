package com.springweb.app.Rest.Reinforcement.Controllers;

import com.springweb.app.Rest.Reinforcement.Models.User;
import com.springweb.app.Rest.Reinforcement.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String saveUser(@RequestBody User user){ //@RequestBody annotation maps the HttpRequest body to a transfer or domain object,
        // enabling automatic deserialization of the inbound HttpRequest body onto a Java object.

        //request body Json
        userRepo.save(user); //pass in new user and save user to the database
        return "Saved new user!";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){//list of users
        return userRepo.findAll();//returns all users from the database.

    }

    @PutMapping (value = "/update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setOccupation(user.getOccupation());
        userRepo.save(updatedUser);
        return "User Updated!";


    }
    @DeleteMapping (value = "/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        User deletedUser = userRepo.findById(id).get();
        userRepo.delete(deletedUser);
        return "Deleted user " + id;

    }
}
