package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.dto.BookDto;
import com.example.LibraryManagementSystem.entity.Book;
import com.example.LibraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lms")
public class BookController {
    @Autowired
    private BookService bookService;

    //create API
    @PostMapping("/addBook")
    public ResponseEntity<Book> createBook(@RequestBody BookDto bookDto){

        Book book =bookService.createBook(bookDto);
        return ResponseEntity.ok(book);
    }

    //Get All Records
    @GetMapping("/getAllRecord")
    public ResponseEntity<List<Book>> getAllBookRecord(){
        List<Book> list= bookService.getAllBook();
        return ResponseEntity.ok(list);
    }

    //delete record by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    // Update record by ID
    @PutMapping("/updateBook/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody BookDto bookDto) {
        Book updatedBook = bookService.updateBook(id, bookDto);
        return ResponseEntity.ok(updatedBook);
    }


}
