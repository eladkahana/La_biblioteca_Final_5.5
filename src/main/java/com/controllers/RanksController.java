package com.controllers;

import com.DTOs.RanksDTO;
import com.entities.Ranks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.services.RanksService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/ranks")
public class RanksController {

    @Autowired
    private RanksService ranksService;

    @PostMapping
    public String save(@Valid @RequestBody Ranks vO) {
        return ranksService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        ranksService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody Ranks vO) {
        ranksService.update(id, vO);
    }

    @GetMapping("/{id}")
    public RanksDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return ranksService.getById(id);
    }

    @GetMapping
    public Page<RanksDTO> query(@Valid Ranks vO) {
        return ranksService.query(vO);
    }
}
