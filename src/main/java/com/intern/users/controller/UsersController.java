package com.intern.users.controller;

import com.intern.users.model.Users;
import com.intern.users.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepo usersRepo;

    boolean userExists(String id) {
        Optional<Users> users = usersRepo.findById(id);
        //if the user is login and present
        if (users.isPresent())
            return true;
        return false;
    }

    //Register
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveUsers(@RequestBody Users users)
    {
        //check if all the fields are correct
        //checks if user already exists
        if(userExists(users.getUser_id()))
            return "user exist";

        usersRepo.save(users);
        return "User saved successfully";
    }

    //login
    //View profile
    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public Users showOrderDetails(@RequestParam("id") String id, @RequestParam("password") String password){
        Optional<Users> user = usersRepo.findById(id);
        if(userExists(id) && user.get().getPassword().equals(password))
        {
            return user.get();
        }
        return null;
    }

    //#update mapping


    /*
    public String getUsers(@PathVariable String  id, @PathVariable String password)
    {

        Optional<Users> user = usersRepo.findById(id);
        if(userExists(id) && user.get().getPassword().equals(password))
        {
            return id;
        }
        return null;
    }*/


    //edit profile
    @PutMapping
    public Users updateUsers(@PathVariable String  id, @RequestBody Users u)
    {
        //get user information
        Optional<Users> users = usersRepo.findById(id);
        //if the user is login and present
        if(users.isPresent())
        {
            return usersRepo.save(u);
        }
        else
        {
            return null;
        }
    }

}
