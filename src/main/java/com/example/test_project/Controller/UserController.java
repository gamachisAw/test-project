package com.example.test_project.Controller;

import com.example.test_project.Model.User;
import com.example.test_project.Service.UserService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping("/save/users")
    public String setUser(@RequestBody User user) {
        userService.saveUser(user);
        return "";
    }

    @GetMapping("/users")
    public  List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/update/users/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user) {
        userService.updateUser(user, id);
        return "";
    }

    @DeleteMapping("delete/users/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return "user is deleted";
    }
}
