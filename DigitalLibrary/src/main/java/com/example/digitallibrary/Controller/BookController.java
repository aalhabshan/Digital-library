package com.example.digitallibrary.Controller;

import com.example.digitallibrary.Dto.ApiResponse;
import com.example.digitallibrary.Model.Book;
import com.example.digitallibrary.Model.LibraryUser;
import com.example.digitallibrary.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class BookController {
    private final BookService bookService;

    @GetMapping("/get")
    public ResponseEntity get(){
        List<Book> book = bookService.get();
        return ResponseEntity.status(200).body(book);
    }
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Book book, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        bookService.add(book);
        return ResponseEntity.status(200).body(new ApiResponse("Book added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid Book book,Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        bookService.update(id, book);
        return ResponseEntity.status(200).body(new ApiResponse("Book updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        bookService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("Book deleted"));
    }
    @GetMapping("/allbyauthor")
    public ResponseEntity auBook(@RequestBody String au){
        List<Book> books= bookService.auBook(au);
        return ResponseEntity.status(200).body(books);
    }
    @GetMapping("/bycategory")
    public ResponseEntity byCategory(@RequestBody String c){
        List<Book> books= bookService.byCategory(c);
        return ResponseEntity.status(200).body(books);
    }
    @GetMapping("/byname")
    public ResponseEntity byName(@RequestBody String name){
        Book book= bookService.byName(name);
        return ResponseEntity.status(200).body(book);
    }
}
