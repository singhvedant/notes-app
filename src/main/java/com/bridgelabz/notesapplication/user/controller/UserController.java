package com.bridgelabz.notesapplication.user.controller;


import com.bridgelabz.notesapplication.user.dto.UserDTO;
import com.bridgelabz.notesapplication.user.entity.Response;
import com.bridgelabz.notesapplication.user.entity.User;
import com.bridgelabz.notesapplication.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    //TODO: Return response entity everywhere
    public Mono<ResponseEntity<Response>> addUser(@RequestBody UserDTO user) {
        Response response = userService.registerUser(user);
        return Mono.just(new ResponseEntity<>(response, HttpStatus.OK));
    }

//    @GetMapping("/getAll")
//    public Flux<ResponseEntity<Response>> getAllUsers() {
//        Response response = userService.getAllUsers();
//        return Flux.just(new ResponseEntity<>(response, HttpStatus.OK));
//    }

    //TODO: Convert id to token
    @GetMapping("/login")
    public Mono<ResponseEntity<Mono<Response>>> loginByEmailAndPassword(@RequestBody UserDTO user) {
        Mono<Response> response = userService.loginService(user);
        return Mono.just(new ResponseEntity<>(response, HttpStatus.OK));
    }

    @PostMapping("/user/{token}")
    public Mono<ResponseEntity<Mono<Response>>> verifyToken(@PathVariable String token) {
        Mono<Response> response = userService.verifyUser(token);
        return Mono.just(new ResponseEntity<>(response, HttpStatus.OK));
    }

    @PutMapping("/update/{id}")
    public Mono<User> updateUser(@PathVariable int id, @RequestBody User user) {
        return null;
    }
}