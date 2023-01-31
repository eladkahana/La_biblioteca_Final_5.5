package com.controllers;

import com.DTOs.BookDTO;
import com.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.services.BookService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public String save(@Valid @RequestBody Book vO) {
        return bookService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        bookService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody Book vO) {
        bookService.update(id, vO);
    }

    @GetMapping("/{id}")
    public BookDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return bookService.getById(id);
    }

    @GetMapping
    public Page<BookDTO> query(@Valid Book vO) {
        return bookService.query(vO);
    }
}
