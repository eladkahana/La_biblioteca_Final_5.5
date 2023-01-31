package com.services;

import com.DTOs.SeriesBookDTO;
import com.entities.SeriesBook;
import com.repositories.SeriesBookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SeriesBookService {

    @Autowired
    private SeriesBookRepository seriesBookRepository;

    public Integer save(SeriesBook vO) {
        SeriesBook bean = new SeriesBook();
        BeanUtils.copyProperties(vO, bean);
        bean = seriesBookRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        seriesBookRepository.deleteById(id);
    }

    public void update(Integer id, SeriesBook vO) {
        SeriesBook bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        seriesBookRepository.save(bean);
    }

    public SeriesBookDTO getById(Integer id) {
        SeriesBook original = requireOne(id);
        return toDTO(original);
    }

    public Page<SeriesBookDTO> query(SeriesBook vO) {
        throw new UnsupportedOperationException();
    }

    private SeriesBookDTO toDTO(SeriesBook original) {
        SeriesBookDTO bean = new SeriesBookDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private SeriesBook requireOne(Integer id) {
        return seriesBookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
