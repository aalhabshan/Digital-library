package com.example.digitallibrary.Repository;

import com.example.digitallibrary.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepsitory extends JpaRepository<Book,Integer> {
    Book findBookById(Integer id);
    public List<Book> findAllByAuthor(String au);
    public List<Book> findAllByCategory(String c);
    public Book findBookByName(String name);
}
