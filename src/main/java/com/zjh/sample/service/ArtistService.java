package com.zjh.sample.service;

import com.zjh.sample.dto.ArtistDTO;
import com.zjh.sample.entity.Artist;
import com.zjh.sample.repository.ArtistRepository;
import com.zjh.sample.vo.ArtistQueryVO;
import com.zjh.sample.vo.ArtistUpdateVO;
import com.zjh.sample.vo.ArtistVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public Integer save(ArtistVO vO) {
        Artist bean = new Artist();
        BeanUtils.copyProperties(vO, bean);
        bean = artistRepository.save(bean);
        return bean.getArtistId();
    }

    public void delete(Integer id) {
        artistRepository.deleteById(id);
    }

    public void update(Integer id, ArtistUpdateVO vO) {
        Artist bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        artistRepository.save(bean);
    }

    public ArtistDTO getById(Integer id) {
        Artist original = requireOne(id);
        return toDTO(original);
    }

    public Page<ArtistDTO> query(ArtistQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ArtistDTO toDTO(Artist original) {
        ArtistDTO bean = new ArtistDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Artist requireOne(Integer id) {
        return artistRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
