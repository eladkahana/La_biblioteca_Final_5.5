package com.controllers;

import com.DTOs.AudienceDTO;
import com.entities.Audience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.services.AudienceService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/audience")
public class AudienceController {

    @Autowired
    private AudienceService audienceService;

    @PostMapping
    public String save(@Valid @RequestBody Audience vO) {
        return audienceService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        audienceService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody Audience vO) {
        audienceService.update(id, vO);
    }

    @GetMapping("/{id}")
    public AudienceDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return audienceService.getById(id);
    }

    @GetMapping
    public Page<AudienceDTO> query(@Valid Audience vO) {
        return audienceService.query(vO);
    }
}
