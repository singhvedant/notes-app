package com.bridgelabz.notesapplication.note.controller;

import com.bridgelabz.notesapplication.note.dto.NoteDTO;
import com.bridgelabz.notesapplication.note.service.NotesServiceImpl;
import com.bridgelabz.notesapplication.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    NotesServiceImpl notesService;

    @GetMapping("/get/{id}/{token}")
    public Mono<ResponseEntity<Response>> getNoteById(@PathVariable int id, @PathVariable String token) {
        return Mono.just(new ResponseEntity<>(notesService.getNoteById(id, token), HttpStatus.OK));
    }

    @PostMapping("/add")
    public ResponseEntity<Response> addNotes(@RequestBody NoteDTO note) {
        return new ResponseEntity<>(notesService.addNote(note), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateNotes(@RequestBody NoteDTO note) {
        return new ResponseEntity<>(notesService.updateNotes(note), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteNote(@PathVariable int id) {
        return new ResponseEntity<>(notesService.deleteNote(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> trashNote(@PathVariable int id) {
        return new ResponseEntity<>(notesService.trashNote(id), HttpStatus.OK);
    }

}
