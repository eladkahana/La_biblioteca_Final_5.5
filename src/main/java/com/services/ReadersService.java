package com.services;

import com.DTOs.ReadersDTO;
import com.entities.Readers;
import com.repositories.ReadersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ReadersService {

    @Autowired
    private ReadersRepository readersRepository;

    public Integer save(Readers vO) {
        Readers bean = new Readers();
        BeanUtils.copyProperties(vO, bean);
        bean = readersRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        readersRepository.deleteById(id);
    }

    public void update(Integer id, Readers vO) {
        Readers bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        readersRepository.save(bean);
    }

    public ReadersDTO getById(Integer id) {
        Readers original = requireOne(id);
        return toDTO(original);
    }

    public Page<ReadersDTO> query(Readers vO) {
        throw new UnsupportedOperationException();
    }

    private ReadersDTO toDTO(Readers original) {
        ReadersDTO bean = new ReadersDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Readers requireOne(Integer id) {
        return readersRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
