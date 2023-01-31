package com.controllers;

import com.DTOs.CategoriesDTO;
import com.entities.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.services.CategoriesService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @PostMapping
    public String save(@Valid @RequestBody Categories vO) {
        return categoriesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        categoriesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody Categories vO) {
        categoriesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CategoriesDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return categoriesService.getById(id);
    }

    @GetMapping
    public Page<CategoriesDTO> query(@Valid Categories vO) {
        return categoriesService.query(vO);
    }
}
