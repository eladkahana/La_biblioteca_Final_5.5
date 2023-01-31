package com.services;

import com.DTOs.ShelfmarkDTO;
import com.entities.Shelfmark;
import com.repositories.ShelfmarkRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ShelfmarkService {

    @Autowired
    private ShelfmarkRepository shelfmarkRepository;

    public Integer save(Shelfmark vO) {
        Shelfmark bean = new Shelfmark();
        BeanUtils.copyProperties(vO, bean);
        bean = shelfmarkRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        shelfmarkRepository.deleteById(id);
    }

    public void update(Integer id, Shelfmark vO) {
        Shelfmark bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        shelfmarkRepository.save(bean);
    }

    public ShelfmarkDTO getById(Integer id) {
        Shelfmark original = requireOne(id);
        return toDTO(original);
    }

    public Page<ShelfmarkDTO> query(Shelfmark vO) {
        throw new UnsupportedOperationException();
    }

    private ShelfmarkDTO toDTO(Shelfmark original) {
        ShelfmarkDTO bean = new ShelfmarkDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Shelfmark requireOne(Integer id) {
        return shelfmarkRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
