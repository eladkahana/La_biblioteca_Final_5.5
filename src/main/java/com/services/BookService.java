package com.services;

import com.DTOs.BookDTO;
import com.entities.Book;
import com.repositories.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Integer save(Book vO) {
        Book bean = new Book();
        BeanUtils.copyProperties(vO, bean);
        bean = bookRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }

    public void update(Integer id, Book vO) {
        Book bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        bookRepository.save(bean);
    }

    public BookDTO getById(Integer id) {
        Book original = requireOne(id);
        return toDTO(original);
    }

    public Page<BookDTO> query(Book vO) {
        throw new UnsupportedOperationException();
    }

    private BookDTO toDTO(Book original) {
        BookDTO bean = new BookDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Book requireOne(Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
