package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.dto.BookDto;
import com.example.LibraryManagementSystem.entity.Book;
import com.example.LibraryManagementSystem.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public Book createBook(BookDto bookDto){
        Book book=new Book();

        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setPublishedYear(bookDto.getPublishedYear());
        book.setCopiesAvailable(bookDto.getCopiesAvailable());
        return bookRepo.save(book);

    }

    public List<Book> getAllBook() {
        return bookRepo.findAll();
    }

    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }

    public Book updateBook(Long id, BookDto bookDto) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();

            book.setTitle(bookDto.getTitle());
            book.setAuthor(bookDto.getAuthor());
            book.setPublishedYear(bookDto.getPublishedYear());
            book.setCopiesAvailable(bookDto.getCopiesAvailable());

            return bookRepo.save(book);
        } else {
            throw new RuntimeException("Course with id " + id + " not found.");
        }
    }
}
