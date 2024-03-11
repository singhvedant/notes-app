package com.bridgelabz.notesapplication.label.repository;

import com.bridgelabz.notesapplication.label.entity.Label;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@EnableR2dbcRepositories
public interface LabelRepo extends R2dbcRepository<Label,Integer> {
}
