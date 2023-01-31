package com.services;

import com.DTOs.AuthorDTO;
import com.entities.Author;
import com.repositories.AuthorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Integer save(Author vO) {
        Author bean = new Author();
        BeanUtils.copyProperties(vO, bean);
        bean = authorRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        authorRepository.deleteById(id);
    }

    public void update(Integer id, Author vO) {
        Author bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        authorRepository.save(bean);
    }

    public AuthorDTO getById(Integer id) {
        Author original = requireOne(id);
        return toDTO(original);
    }

    public Page<AuthorDTO> query(Author vO) {
        throw new UnsupportedOperationException();
    }

    private AuthorDTO toDTO(Author original) {
        AuthorDTO bean = new AuthorDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Author requireOne(Integer id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
