package com.bridgelabz.notesapplication.note.repository;

import com.bridgelabz.notesapplication.note.entity.Note;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@EnableR2dbcRepositories
public interface NotesRepo extends R2dbcRepository<Note,Integer> {
}
