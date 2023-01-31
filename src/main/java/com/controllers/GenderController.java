package com.controllers;

import com.DTOs.GenderDTO;
import com.entities.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.services.GenderService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/gender")
public class GenderController {

    @Autowired
    private GenderService genderService;

    @PostMapping
    public String save(@Valid @RequestBody Gender vO) {
        return genderService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        genderService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody Gender vO) {
        genderService.update(id, vO);
    }

    @GetMapping("/{id}")
    public GenderDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return genderService.getById(id);
    }

    @GetMapping
    public Page<GenderDTO> query(@Valid Gender vO) {
        return genderService.query(vO);
    }
}
