package com.bridgelabz.notesapplication.label.entity;

import com.bridgelabz.notesapplication.note.entity.Note;
import jakarta.persistence.ManyToMany;
import lombok.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("user-label")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserLabel {
    @Column
    @ManyToMany(targetEntity = Label.class)
    protected int labelId;
    @Column
    @ManyToMany(targetEntity = Note.class)
    protected int noteId;
}
