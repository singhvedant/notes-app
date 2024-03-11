package com.bridgelabz.notesapplication.user.repository;

import com.bridgelabz.notesapplication.user.entity.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@EnableR2dbcRepositories
public interface UserRepository extends R2dbcRepository<User,Integer> {
}
