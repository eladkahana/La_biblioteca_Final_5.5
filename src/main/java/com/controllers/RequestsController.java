package com.controllers;

import com.DTOs.RequestsDTO;
import com.entities.Requests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.services.RequestsService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/requests")
public class RequestsController {

    @Autowired
    private RequestsService requestsService;

    @PostMapping
    public String save(@Valid @RequestBody Requests vO) {
        return requestsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        requestsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody Requests vO) {
        requestsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public RequestsDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return requestsService.getById(id);
    }

    @GetMapping
    public Page<RequestsDTO> query(@Valid Requests vO) {
        return requestsService.query(vO);
    }
}
