package com.services;

import com.DTOs.RequestsDTO;
import com.entities.Requests;
import com.repositories.RequestsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RequestsService {

    @Autowired
    private RequestsRepository requestsRepository;

    public Integer save(Requests vO) {
        Requests bean = new Requests();
        BeanUtils.copyProperties(vO, bean);
        bean = requestsRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        requestsRepository.deleteById(id);
    }

    public void update(Integer id, Requests vO) {
        Requests bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        requestsRepository.save(bean);
    }

    public RequestsDTO getById(Integer id) {
        Requests original = requireOne(id);
        return toDTO(original);
    }

    public Page<RequestsDTO> query(Requests vO) {
        throw new UnsupportedOperationException();
    }

    private RequestsDTO toDTO(Requests original) {
        RequestsDTO bean = new RequestsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Requests requireOne(Integer id) {
        return requestsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
