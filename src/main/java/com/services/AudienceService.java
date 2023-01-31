package com.services;

import com.DTOs.AudienceDTO;
import com.entities.Audience;
import com.repositories.AudienceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AudienceService {

    @Autowired
    private AudienceRepository audienceRepository;

    public Integer save(Audience vO) {
        Audience bean = new Audience();
        BeanUtils.copyProperties(vO, bean);
        bean = audienceRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        audienceRepository.deleteById(id);
    }

    public void update(Integer id, Audience vO) {
        Audience bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        audienceRepository.save(bean);
    }

    public AudienceDTO getById(Integer id) {
        Audience original = requireOne(id);
        return toDTO(original);
    }

    public Page<AudienceDTO> query(Audience vO) {
        throw new UnsupportedOperationException();
    }

    private AudienceDTO toDTO(Audience original) {
        AudienceDTO bean = new AudienceDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Audience requireOne(Integer id) {
        return audienceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
