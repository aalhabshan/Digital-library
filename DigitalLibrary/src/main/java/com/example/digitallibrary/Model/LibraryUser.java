package com.example.digitallibrary.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LibraryUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 3,message = "Name Should be mor than 2 letter ")
    @NotNull(message = "Name shouldn't be empty")
    private String name;

    @Column(columnDefinition = "varchar(15) unique")
    @NotNull(message = "Username shouldn't be empty")
    @Size(min = 3,message = "Username Should be mor than 2 letter ")
    private String username;
    @NotNull(message = "Password shouldn't be empty")
    private String password;

    @NotNull(message = "Role shouldn't be empty")
    private String role;

    @OneToMany(mappedBy = "id")
    @JsonIgnore
    private Set<Rate> rates;
}
