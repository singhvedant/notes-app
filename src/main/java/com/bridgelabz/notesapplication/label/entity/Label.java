package com.bridgelabz.notesapplication.label.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("label")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected int labelId;
    @Column
    protected String labelName;
    @Column
    protected int userId;
    @Column
    protected int noteId;
}
