package com.services;

import com.DTOs.CopiesDTO;
import com.entities.Copies;
import com.repositories.CopiesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CopiesService {

    @Autowired
    private CopiesRepository copiesRepository;

    public Integer save(Copies vO) {
        Copies bean = new Copies();
        BeanUtils.copyProperties(vO, bean);
        bean = copiesRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        copiesRepository.deleteById(id);
    }

    public void update(Integer id, Copies vO) {
        Copies bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        copiesRepository.save(bean);
    }

    public CopiesDTO getById(Integer id) {
        Copies original = requireOne(id);
        return toDTO(original);
    }

    public Page<CopiesDTO> query(Copies vO) {
        throw new UnsupportedOperationException();
    }

    private CopiesDTO toDTO(Copies original) {
        CopiesDTO bean = new CopiesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Copies requireOne(Integer id) {
        return copiesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
