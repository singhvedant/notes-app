package com.bridgelabz.notesapplication.note.service;

import com.bridgelabz.notesapplication.note.entity.Note;
import com.bridgelabz.notesapplication.note.repository.NotesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    NotesRepo notesRepo;

    public Mono<Note> addNote(Note note) {
        return notesRepo.save(note);
    }

    public Mono<Note> updateNotes(Note note) {
        return notesRepo.save(note);
    }

    public Mono<Void> deleteNotes(int id) {
        return notesRepo.deleteById(id);
    }

    public Mono<Note> getNoteById(int id) {
        return notesRepo.findById(id);
    }

    public Mono<Void> deleteAllNotes() {
        return notesRepo.deleteAll();
    }
}
