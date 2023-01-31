package com.services;

import com.DTOs.LastNameDTO;
import com.entities.LastName;
import com.repositories.LastNameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class LastNameService {

    @Autowired
    private LastNameRepository lastNameRepository;

    public Integer save(LastName vO) {
        LastName bean = new LastName();
        BeanUtils.copyProperties(vO, bean);
        bean = lastNameRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        lastNameRepository.deleteById(id);
    }

    public void update(Integer id, LastName vO) {
        LastName bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        lastNameRepository.save(bean);
    }

    public LastNameDTO getById(Integer id) {
        LastName original = requireOne(id);
        return toDTO(original);
    }

    public Page<LastNameDTO> query(LastName vO) {
        throw new UnsupportedOperationException();
    }

    private LastNameDTO toDTO(LastName original) {
        LastNameDTO bean = new LastNameDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private LastName requireOne(Integer id) {
        return lastNameRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
