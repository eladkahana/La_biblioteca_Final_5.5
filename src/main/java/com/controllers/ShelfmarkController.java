package com.controllers;

import com.entities.ShelfmarkEntity;
import com.services.ShelfmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/shelfmark")
public class ShelfmarkController {

    @Autowired
    private ShelfmarkService shelfmarkService;

    @PostMapping
    public String save(@Valid @RequestBody ShelfmarkEntity vO) {
        return shelfmarkService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        shelfmarkService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody ShelfmarkEntity vO) {
        shelfmarkService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ShelfmarkEntity getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return shelfmarkService.getById(id);
    }


}
