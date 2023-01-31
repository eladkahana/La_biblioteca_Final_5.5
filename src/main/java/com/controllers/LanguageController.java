package com.controllers;

import com.DTOs.LanguageDTO;
import com.entities.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.services.LanguageService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @PostMapping
    public String save(@Valid @RequestBody Language vO) {
        return languageService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        languageService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody Language vO) {
        languageService.update(id, vO);
    }

    @GetMapping("/{id}")
    public LanguageDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return languageService.getById(id);
    }

    @GetMapping
    public Page<LanguageDTO> query(@Valid Language vO) {
        return languageService.query(vO);
    }
}
