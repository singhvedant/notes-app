package com.bridgelabz.notesapplication.user.service;

import com.bridgelabz.notesapplication.user.dto.UserDTO;
import com.bridgelabz.notesapplication.user.entity.Response;
import com.bridgelabz.notesapplication.user.entity.User;
import com.bridgelabz.notesapplication.user.exception.LoginException;
import com.bridgelabz.notesapplication.user.exception.RegistrationException;
import com.bridgelabz.notesapplication.user.repository.UserRepository;
import com.bridgelabz.notesapplication.user.util.UserToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Environment environment;


// TODO : Handel exception

    public Response getAllUsers() {
        Flux<User> allUsers = userRepository.findAll();
        return new Response(
                environment.getProperty("status.register.userAlreadyExist"),
                Integer.parseInt(Objects.requireNonNull(environment.getProperty("status.token.ErrorCode")))
        );
    }

    public Response loginService(UserDTO userDTO) throws LoginException {
        User userDAO = userRepository.findAll().toStream()
                .filter(s -> s.getEmail().equals(userDTO.getEmail()))
                .findFirst()
                .orElse(null);
        if (userDAO != null) {
            if (userDAO.getPassword().equals(userDTO.getPassword())) {
                return new Response(environment.getProperty("status.login.success"), userDAO, Integer.parseInt(Objects.requireNonNull(environment.getProperty("status.login.successCode"))));
            } else {
                throw new LoginException(environment.getProperty("status.login.passwordIncorrect"));
            }
        } else {
            throw new LoginException(environment.getProperty("status.login.userNotFound"));
        }
    }

    public Mono<Void> deleteUser(int id) {
        return userRepository.deleteById(id);
    }



    public Response registerUser(UserDTO user) throws RegistrationException {
        if (userRepository.findAll().toStream().anyMatch(s -> !s.getEmail().equals(user.getEmail()))) {
            throw new RegistrationException(environment.getProperty("status.register.userAlreadyExist"));
        }
        ModelMapper modelMapper = new ModelMapper();
        User newUser = modelMapper.map(user, User.class);
        Mono<User> savedUser = userRepository.save(newUser);
        return new Response("User added successfully", savedUser, 200);

    }

    public Mono<User> updateUser(UserDTO newUser) {
        return null;
    }
}
