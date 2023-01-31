package com.controllers;

import com.DTOs.ResponesDTO;
import com.entities.Respones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.services.ResponesService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/respones")
public class ResponesController {

    @Autowired
    private ResponesService responesService;

    @PostMapping
    public String save(@Valid @RequestBody Respones vO) {
        return responesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        responesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody Respones vO) {
        responesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ResponesDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return responesService.getById(id);
    }

    @GetMapping
    public Page<ResponesDTO> query(@Valid Respones vO) {
        return responesService.query(vO);
    }
}
