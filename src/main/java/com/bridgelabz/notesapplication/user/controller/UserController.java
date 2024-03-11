package com.bridgelabz.notesapplication.user.controller;


import com.bridgelabz.notesapplication.user.entity.User;
import com.bridgelabz.notesapplication.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    protected Mono<User> registerController(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/getAll")
    protected Flux<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get/{id}")
    protected Mono<User> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    protected Mono<Void> deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @PutMapping("/update/{id}")
    protected Mono<User> updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
}