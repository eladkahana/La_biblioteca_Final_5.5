package com.controllers;

import com.DTOs.ShelfmarkDTO;
import com.entities.Shelfmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.services.ShelfmarkService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/shelfmark")
public class ShelfmarkController {

    @Autowired
    private ShelfmarkService shelfmarkService;

    @PostMapping
    public String save(@Valid @RequestBody Shelfmark vO) {
        return shelfmarkService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        shelfmarkService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody Shelfmark vO) {
        shelfmarkService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ShelfmarkDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return shelfmarkService.getById(id);
    }

    @GetMapping
    public Page<ShelfmarkDTO> query(@Valid Shelfmark vO) {
        return shelfmarkService.query(vO);
    }
}
