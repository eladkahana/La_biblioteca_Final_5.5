package com.controllers;

import com.DTOs.CopiesDTO;
import com.entities.Copies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.services.CopiesService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/copies")
public class CopiesController {

    @Autowired
    private CopiesService copiesService;

    @PostMapping
    public String save(@Valid @RequestBody Copies vO) {
        return copiesService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        copiesService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody Copies vO) {
        copiesService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CopiesDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return copiesService.getById(id);
    }

    @GetMapping
    public Page<CopiesDTO> query(@Valid Copies vO) {
        return copiesService.query(vO);
    }
}
