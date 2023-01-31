package com.services;

import com.DTOs.FirstNameDTO;
import com.entities.FirstName;
import com.repositories.FirstNameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class FirstNameService {

    @Autowired
    private FirstNameRepository firstNameRepository;

    public Integer save(FirstName vO) {
        FirstName bean = new FirstName();
        BeanUtils.copyProperties(vO, bean);
        bean = firstNameRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        firstNameRepository.deleteById(id);
    }

    public void update(Integer id, FirstName vO) {
        FirstName bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        firstNameRepository.save(bean);
    }

    public FirstNameDTO getById(Integer id) {
        FirstName original = requireOne(id);
        return toDTO(original);
    }

    public Page<FirstNameDTO> query(FirstName vO) {
        throw new UnsupportedOperationException();
    }

    private FirstNameDTO toDTO(FirstName original) {
        FirstNameDTO bean = new FirstNameDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private FirstName requireOne(Integer id) {
        return firstNameRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
