package com.services;

import com.DTOs.CategoriesDTO;
import com.entities.Categories;
import com.repositories.CategoriesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    public Integer save(Categories vO) {
        Categories bean = new Categories();
        BeanUtils.copyProperties(vO, bean);
        bean = categoriesRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        categoriesRepository.deleteById(id);
    }

    public void update(Integer id, Categories vO) {
        Categories bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        categoriesRepository.save(bean);
    }

    public CategoriesDTO getById(Integer id) {
        Categories original = requireOne(id);
        return toDTO(original);
    }

    public Page<CategoriesDTO> query(Categories vO) {
        throw new UnsupportedOperationException();
    }

    private CategoriesDTO toDTO(Categories original) {
        CategoriesDTO bean = new CategoriesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Categories requireOne(Integer id) {
        return categoriesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
