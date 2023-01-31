package com.controllers;

import com.DTOs.AuthorDTO;
import com.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.services.AuthorService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public String save(@Valid @RequestBody Author vO) {
        return authorService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        authorService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody Author vO) {
        authorService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AuthorDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return authorService.getById(id);
    }

    @GetMapping
    public Page<AuthorDTO> query(@Valid Author vO) {
        return authorService.query(vO);
    }
}
