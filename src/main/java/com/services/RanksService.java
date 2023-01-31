package com.services;

import com.DTOs.RanksDTO;
import com.entities.Ranks;
import com.repositories.RanksRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RanksService {

    @Autowired
    private RanksRepository ranksRepository;

    public Integer save(Ranks vO) {
        Ranks bean = new Ranks();
        BeanUtils.copyProperties(vO, bean);
        bean = ranksRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        ranksRepository.deleteById(id);
    }

    public void update(Integer id, Ranks vO) {
        Ranks bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        ranksRepository.save(bean);
    }

    public RanksDTO getById(Integer id) {
        Ranks original = requireOne(id);
        return toDTO(original);
    }

    public Page<RanksDTO> query(Ranks vO) {
        throw new UnsupportedOperationException();
    }

    private RanksDTO toDTO(Ranks original) {
        RanksDTO bean = new RanksDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Ranks requireOne(Integer id) {
        return ranksRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
