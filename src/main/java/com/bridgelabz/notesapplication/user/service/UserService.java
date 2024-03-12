package com.bridgelabz.notesapplication.user.service;

import com.bridgelabz.notesapplication.user.dto.UserDTO;
import com.bridgelabz.notesapplication.util.Response;
import com.bridgelabz.notesapplication.user.entity.User;
import com.bridgelabz.notesapplication.user.exception.LoginException;
import com.bridgelabz.notesapplication.user.exception.RegistrationException;
import com.bridgelabz.notesapplication.user.repository.UserRepository;
import com.bridgelabz.notesapplication.util.UserToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Environment environment;

//    public Response getAllUsers() {
////        Flux<User> allUsers = userRepository.findAll();
//        return new Response(
//                environment.getProperty("status.register.userAlreadyExist"),
//                Integer.parseInt(Objects.requireNonNull(environment.getProperty("status.token.ErrorCode")))
//        );
//    }

    public Mono<Response> loginService(UserDTO userDTO) {
        return userRepository.findAll()
                .filter(user -> user.getEmail().equals(userDTO.getEmail()))
                .next() // This effectively replaces findFirst, as it returns the first item in the stream or empty if the stream is empty.
                .flatMap(userDAO -> {
                    if (userDAO.getPassword().equals(userDTO.getPassword())) {
                        String token = UserToken.generateToken(userDAO.getId());
                        String message = "status.login.success";
                        int successCode = Integer.parseInt("3");
                        return Mono.just(new Response(message, token, successCode));
                    } else {
                        return Mono.error(new LoginException("status.login.passwordIncorrect"));
                    }
                })
                .switchIfEmpty(Mono.error(new LoginException("status.login.userNotFound")));
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

    public Response verifyUser(String token) {
        try {
            int id = UserToken.verifyToken(token);
            return new Response("User verified successfully", id, 200);
        } catch (Exception e) {
            return new Response("User verification failed", e, 400);
        }
    }
}
