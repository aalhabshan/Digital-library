package com.example.digitallibrary.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name shouldn't be empty")
    private String name;

    @NotEmpty(message = "Author shouldn't be empty")
    private String author;

    @NotNull(message = "Role shouldn't be empty")
    private Integer price;
    @NotEmpty(message = "Category shouldn't be empty")
    private String category;
//    @OneToMany(mappedBy = "id")
//    @JsonIgnore
//    private Set<Rate> rates;
}
