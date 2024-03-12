package com.bridgelabz.notesapplication.note.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "notes")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int noteId;
    @Column
    private String note;
    @Column
    private int userId;
    //TODO : Implement Trash and other features that are there in NoteDTO
}
