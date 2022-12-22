package com.example.digitallibrary.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Book shouldn't be empty")
    private String bookname;
    @Size(max = 200,message = "Maximum is 200 letters")
    private String comment;

    @Max(value = 5,message = "Maximum rate is 5")
    @Min(value = 1,message = "Minimum rate is 1")
    private Integer rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", referencedColumnName = "id")
    private LibraryUser user;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "bookud", referencedColumnName = "id")
//    private Book book;
}
