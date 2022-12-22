package com.example.digitallibrary.Service;

import com.example.digitallibrary.Exception.ApiException;
import com.example.digitallibrary.Model.Book;
import com.example.digitallibrary.Model.LibraryUser;
import com.example.digitallibrary.Repository.BookRepsitory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepsitory bookRepsitory;

    public List<Book> get(){
        return bookRepsitory.findAll();
    }
    public void add(Book book){
        bookRepsitory.save(book);
    }
    public void update(Integer id,Book book){
        Book b = bookRepsitory.findBookById(id);
        if (b==null)
            throw new ApiException("Wrong ID!!");
        b.setName(book.getName());
        b.setPrice(book.getPrice());
        b.setCategory(book.getCategory());
        b.setAuthor(book.getAuthor());
        bookRepsitory.save(b);
    }
    public void delete(Integer id){
        Book b = bookRepsitory.findBookById(id);
        if (b==null)
            throw new ApiException("Wrong ID!!");
        bookRepsitory.deleteById(id);
    }
    public List<Book> auBook(String au){
        List<Book> books= bookRepsitory.findAllByAuthor(au);
        if (books.isEmpty())
            throw new ApiException("Wrong author!!");
        return books;
    }
    public List<Book> byCategory(String c){
        List<Book> books= bookRepsitory.findAllByCategory(c);
        if (books.isEmpty())
            throw new ApiException("Wrong Category!!");
        return books;
    }
    public Book byName(String name){
        Book b = bookRepsitory.findBookByName(name);
        if (b==null)
            throw new ApiException("Wrong name!!");
        return b;
    }


}
