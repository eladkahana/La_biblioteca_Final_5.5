package com.controllers;

import com.DTOs.ReadersDTO;
import com.entities.Readers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.services.ReadersService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/readers")
public class ReadersController {

    @Autowired
    private ReadersService readersService;

    @PostMapping
    public String save(@Valid @RequestBody Readers vO) {
        return readersService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        readersService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody Readers vO) {
        readersService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ReadersDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return readersService.getById(id);
    }

    @GetMapping
    public Page<ReadersDTO> query(@Valid Readers vO) {
        return readersService.query(vO);
    }
}
