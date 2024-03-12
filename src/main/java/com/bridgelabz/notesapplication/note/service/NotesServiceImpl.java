package com.bridgelabz.notesapplication.note.service;

import com.bridgelabz.notesapplication.note.dto.NoteDTO;
import com.bridgelabz.notesapplication.note.entity.Note;
import com.bridgelabz.notesapplication.note.repository.NotesRepo;
import com.bridgelabz.notesapplication.util.Response;
import com.bridgelabz.notesapplication.util.UserToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    NotesRepo notesRepo;
//TODO : Exception handling here
    public Response addNote(NoteDTO noteDTO) {
        //TODO: NOTENOTFOUND EXCEPTION
        ModelMapper modelMapper = new ModelMapper();
        Note noteDAO = modelMapper.map(noteDTO, Note.class);
        Mono<Note> note = notesRepo.save(noteDAO);
        return new Response("Note added successfully", note, 200);
    }

    public Response updateNotes(NoteDTO note) {
        // TODO: NOTENOTFOUND EXCEPTION
        ModelMapper modelMapper = new ModelMapper();
        Note noteDAO = modelMapper.map(note, Note.class);
        Mono<Note> updatedNote = notesRepo.save(noteDAO);
        return new Response("Note updated successfully", updatedNote, 200);
    }

    public Response deleteNote(int id) {
        // TODO : NOTENOTFOUND EXCEPTION
        notesRepo.deleteById(id);
        return new Response("Note deleted successfully", 200);
    }

    public Response getNoteById(int id, String token) {
        // TODO : NOTENOTFOUND EXCEPTION
        Mono<Note> note = notesRepo.findById(id).filter(searchNote -> searchNote.getUserId() == UserToken.verifyToken(token));
        return new Response("Success", note, 200);
    }

    public Response trashNote(int id) {
        //TODO : Implement Trash Features
        // TODO : NOTENOTFOUND EXCEPTION
        return new Response("Note moved to trash", 5050);
    }
}
