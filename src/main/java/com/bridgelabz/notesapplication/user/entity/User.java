package com.bridgelabz.notesapplication.user.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;


@Table(name="USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    @NonNull
    private String name;
    @Column
    @NonNull
    private String email;
    @Column
    @NonNull
    private String password;
    @Column
    private boolean isVerified;
    @Column
    private LocalDate createdDate;
    @Column
    private LocalDate updatedDate;
    @Column
    private String profilePic;
    @Column
    private String country;
    @Column
    private String mobileNumber;
    @Column
    private String address;

}
