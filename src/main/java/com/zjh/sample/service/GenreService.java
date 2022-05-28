package com.zjh.sample.service;

import com.zjh.sample.dto.GenreDTO;
import com.zjh.sample.entity.Genre;
import com.zjh.sample.repository.GenreRepository;
import com.zjh.sample.vo.GenreQueryVO;
import com.zjh.sample.vo.GenreUpdateVO;
import com.zjh.sample.vo.GenreVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public Integer save(GenreVO vO) {
        Genre bean = new Genre();
        BeanUtils.copyProperties(vO, bean);
        bean = genreRepository.save(bean);
        return bean.getGenreId();
    }

    public void delete(Integer id) {
        genreRepository.deleteById(id);
    }

    public void update(Integer id, GenreUpdateVO vO) {
        Genre bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        genreRepository.save(bean);
    }

    public GenreDTO getById(Integer id) {
        Genre original = requireOne(id);
        return toDTO(original);
    }

    public Page<GenreDTO> query(GenreQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private GenreDTO toDTO(Genre original) {
        GenreDTO bean = new GenreDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Genre requireOne(Integer id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
