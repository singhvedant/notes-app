package com.bridgelabz.notesapplication.note.controller;

import com.bridgelabz.notesapplication.note.entity.Note;
import com.bridgelabz.notesapplication.note.service.NotesService;
import com.bridgelabz.notesapplication.note.service.NotesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    NotesServiceImpl notesService;

    @PostMapping("/add")
    public Mono<Note> addNotes(@RequestBody Note note) {
        return notesService.addNote(note);
    }

    @PutMapping("/update")
    public Mono<Note> updateNotes(@RequestBody Note note) {
        return notesService.updateNotes(note);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteNotes(@PathVariable int id) {
        return notesService.deleteNotes(id);
    }

    @GetMapping("/get/{id}")
    public Mono<Note> getNoteById(@PathVariable int id) {
        return notesService.getNoteById(id);
    }

    @DeleteMapping("/deleteAll")
    public Mono<Void> deleteAllNotes() {
        return notesService.deleteAllNotes();
    }

}
