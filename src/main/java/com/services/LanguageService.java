package com.services;

import com.DTOs.LanguageDTO;
import com.entities.Language;
import com.repositories.LanguageRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public Integer save(Language vO) {
        Language bean = new Language();
        BeanUtils.copyProperties(vO, bean);
        bean = languageRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        languageRepository.deleteById(id);
    }

    public void update(Integer id, Language vO) {
        Language bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        languageRepository.save(bean);
    }

    public LanguageDTO getById(Integer id) {
        Language original = requireOne(id);
        return toDTO(original);
    }

    public Page<LanguageDTO> query(Language vO) {
        throw new UnsupportedOperationException();
    }

    private LanguageDTO toDTO(Language original) {
        LanguageDTO bean = new LanguageDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Language requireOne(Integer id) {
        return languageRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
