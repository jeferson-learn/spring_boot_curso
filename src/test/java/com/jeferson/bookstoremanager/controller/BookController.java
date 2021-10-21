package com.jeferson.bookstoremanager.controller;

import com.jeferson.bookstoremanager.dto.MessageResponseDTO;
import com.jeferson.bookstoremanager.entity.Book;
import com.jeferson.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/messagem")
    public String teste(){
        return "Olá";
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody Book book) {
        Book savedBook = bookRepository.save(book);
        return MessageResponseDTO.builder()
                .message("Book created with ID " + savedBook.getId())
                .build();
    }
}
