package com.controllers;

import com.DTOs.FirstNameDTO;
import com.entities.FirstName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.services.FirstNameService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/firstName")
public class FirstNameController {

    @Autowired
    private FirstNameService firstNameService;

    @PostMapping
    public String save(@Valid @RequestBody FirstName vO) {
        return firstNameService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        firstNameService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody FirstName vO) {
        firstNameService.update(id, vO);
    }

    @GetMapping("/{id}")
    public FirstNameDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return firstNameService.getById(id);
    }

    @GetMapping
    public Page<FirstNameDTO> query(@Valid FirstName vO) {
        return firstNameService.query(vO);
    }
}
