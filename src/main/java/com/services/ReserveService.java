package com.services;

import com.DTOs.ReserveDTO;
import com.entities.Reserve;
import com.repositories.ReserveRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ReserveService {

    @Autowired
    private ReserveRepository reserveRepository;

    public Integer save(Reserve vO) {
        Reserve bean = new Reserve();
        BeanUtils.copyProperties(vO, bean);
        bean = reserveRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        reserveRepository.deleteById(id);
    }

    public void update(Integer id, Reserve vO) {
        Reserve bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        reserveRepository.save(bean);
    }

    public ReserveDTO getById(Integer id) {
        Reserve original = requireOne(id);
        return toDTO(original);
    }

    public Page<ReserveDTO> query(Reserve vO) {
        throw new UnsupportedOperationException();
    }

    private ReserveDTO toDTO(Reserve original) {
        ReserveDTO bean = new ReserveDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Reserve requireOne(Integer id) {
        return reserveRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
