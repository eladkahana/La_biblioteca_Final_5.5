package com.services;

import com.DTOs.PublisherDTO;
import com.entities.Publisher;
import com.repositories.PublisherRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public Integer save(Publisher vO) {
        Publisher bean = new Publisher();
        BeanUtils.copyProperties(vO, bean);
        bean = publisherRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        publisherRepository.deleteById(id);
    }

    public void update(Integer id, Publisher vO) {
        Publisher bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        publisherRepository.save(bean);
    }

    public PublisherDTO getById(Integer id) {
        Publisher original = requireOne(id);
        return toDTO(original);
    }

    public Page<PublisherDTO> query(Publisher vO) {
        throw new UnsupportedOperationException();
    }

    private PublisherDTO toDTO(Publisher original) {
        PublisherDTO bean = new PublisherDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Publisher requireOne(Integer id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
