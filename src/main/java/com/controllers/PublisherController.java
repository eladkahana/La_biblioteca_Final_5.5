package com.controllers;

import com.DTOs.PublisherDTO;
import com.entities.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.services.PublisherService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping
    public String save(@Valid @RequestBody Publisher vO) {
        return publisherService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        publisherService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody Publisher vO) {
        publisherService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PublisherDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return publisherService.getById(id);
    }

    @GetMapping
    public Page<PublisherDTO> query(@Valid Publisher vO) {
        return publisherService.query(vO);
    }
}
