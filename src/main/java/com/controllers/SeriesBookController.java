package com.controllers;

import com.DTOs.SeriesBookDTO;
import com.entities.SeriesBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.services.SeriesBookService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/seriesBook")
public class SeriesBookController {

    @Autowired
    private SeriesBookService seriesBookService;

    @PostMapping
    public String save(@Valid @RequestBody SeriesBook vO) {
        return seriesBookService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        seriesBookService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody SeriesBook vO) {
        seriesBookService.update(id, vO);
    }

    @GetMapping("/{id}")
    public SeriesBookDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return seriesBookService.getById(id);
    }

    @GetMapping
    public Page<SeriesBookDTO> query(@Valid SeriesBook vO) {
        return seriesBookService.query(vO);
    }
}
