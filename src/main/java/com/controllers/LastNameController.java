package com.controllers;

import com.DTOs.LastNameDTO;
import com.entities.LastName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.services.LastNameService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/lastName")
public class LastNameController {

    @Autowired
    private LastNameService lastNameService;

    @PostMapping
    public String save(@Valid @RequestBody LastName vO) {
        return lastNameService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        lastNameService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody LastName vO) {
        lastNameService.update(id, vO);
    }

    @GetMapping("/{id}")
    public LastNameDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return lastNameService.getById(id);
    }

    @GetMapping
    public Page<LastNameDTO> query(@Valid LastName vO) {
        return lastNameService.query(vO);
    }
}
