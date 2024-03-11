package com.bridgelabz.notesapplication.user.service;

import com.bridgelabz.notesapplication.user.entity.User;
import com.bridgelabz.notesapplication.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    public Mono<User> addUser(User user) {
        return userRepository.save(user);
    }

    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Mono<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public Mono<Void> deleteUser(int id) {
        return userRepository.deleteById(id);
    }

    public Mono<User> updateUser(int id, User user) {
        return userRepository.findById(id)
                .flatMap(existingUser -> {
                    existingUser.setName(user.getName());
                    existingUser.setEmail(user.getEmail());
                    existingUser.setPassword(user.getPassword());
                    return userRepository.save(existingUser);
                });
    }
}
