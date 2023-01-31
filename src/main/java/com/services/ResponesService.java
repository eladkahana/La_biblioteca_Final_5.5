package com.services;

import com.DTOs.ResponesDTO;
import com.entities.Respones;
import com.repositories.ResponesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ResponesService {

    @Autowired
    private ResponesRepository responesRepository;

    public Integer save(Respones vO) {
        Respones bean = new Respones();
        BeanUtils.copyProperties(vO, bean);
        bean = responesRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        responesRepository.deleteById(id);
    }

    public void update(Integer id, Respones vO) {
        Respones bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        responesRepository.save(bean);
    }

    public ResponesDTO getById(Integer id) {
        Respones original = requireOne(id);
        return toDTO(original);
    }

    public Page<ResponesDTO> query(Respones vO) {
        throw new UnsupportedOperationException();
    }

    private ResponesDTO toDTO(Respones original) {
        ResponesDTO bean = new ResponesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Respones requireOne(Integer id) {
        return responesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
