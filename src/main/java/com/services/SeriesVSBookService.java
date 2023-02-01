package com.services;

import com.entities.SeriesVsBookEntity;
import com.repositories.SeriesVSBookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SeriesVSBookService {

    @Autowired
    private SeriesVSBookRepository seriesVSBookRepository;

    public Integer save(SeriesVsBookEntity vO) {
        SeriesVsBookEntity bean = new SeriesVsBookEntity();
        BeanUtils.copyProperties(vO, bean);
        bean = seriesVSBookRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        seriesVSBookRepository.deleteById(id);
    }

    public void update(Integer id, SeriesVsBookEntity vO) {
        SeriesVsBookEntity bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        seriesVSBookRepository.save(bean);
    }

    public SeriesVsBookEntity getById(Integer id) {
        SeriesVsBookEntity original = requireOne(id);
        return toDTO(original);
    }


    private SeriesVsBookEntity toDTO(SeriesVsBookEntity original) {
        SeriesVsBookEntity bean = new SeriesVsBookEntity();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private SeriesVsBookEntity requireOne(Integer id) {
        return seriesVSBookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
