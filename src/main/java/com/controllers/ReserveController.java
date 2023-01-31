package com.controllers;

import com.DTOs.ReserveDTO;
import com.entities.Reserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.services.ReserveService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/reserve")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @PostMapping
    public String save(@Valid @RequestBody Reserve vO) {
        return reserveService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        reserveService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody Reserve vO) {
        reserveService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ReserveDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return reserveService.getById(id);
    }

    @GetMapping
    public Page<ReserveDTO> query(@Valid Reserve vO) {
        return reserveService.query(vO);
    }
}
