package com.as.usermanagement.resources;

import com.as.usermanagement.model.UserModel;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management/api/v1/user")
public class UserManagementResource {

    List<UserModel> users = Arrays.asList(
            new UserModel(1, "Rohan Mishra"),
            new UserModel(2, "Harshad Metha"),
            new UserModel(3, "Manu Bhai Desai")
    );

    @GetMapping
    public List<UserModel> getAllUsers(){
        return users;
    }

    @PostMapping
    public void registerUser(@RequestBody UserModel userModel){
        System.out.println("User Registered Successfully ");
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable int userId){
        System.out.println("User Deleted Successfully " + userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable int userId, @RequestBody UserModel userModel){
        System.out.println("User Registered Successfully " + userId);
    }

}
