package com.services;

import com.DTOs.GenderDTO;
import com.entities.Gender;
import com.repositories.GenderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class GenderService {

    @Autowired
    private GenderRepository genderRepository;

    public Integer save(Gender vO) {
        Gender bean = new Gender();
        BeanUtils.copyProperties(vO, bean);
        bean = genderRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        genderRepository.deleteById(id);
    }

    public void update(Integer id, Gender vO) {
        Gender bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        genderRepository.save(bean);
    }

    public GenderDTO getById(Integer id) {
        Gender original = requireOne(id);
        return toDTO(original);
    }

    public Page<GenderDTO> query(Gender vO) {
        throw new UnsupportedOperationException();
    }

    private GenderDTO toDTO(Gender original) {
        GenderDTO bean = new GenderDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Gender requireOne(Integer id) {
        return genderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
