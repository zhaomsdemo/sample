package com.zjh.sample.service;

import com.zjh.sample.dto.AlbumDTO;
import com.zjh.sample.entity.Album;
import com.zjh.sample.repository.AlbumRepository;
import com.zjh.sample.vo.AlbumQueryVO;
import com.zjh.sample.vo.AlbumUpdateVO;
import com.zjh.sample.vo.AlbumVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Integer save(AlbumVO vO) {
        Album bean = new Album();
        BeanUtils.copyProperties(vO, bean);
        bean = albumRepository.save(bean);
        return bean.getAlbumId();
    }

    public void delete(Integer id) {
        albumRepository.deleteById(id);
    }

    public void update(Integer id, AlbumUpdateVO vO) {
        Album bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        albumRepository.save(bean);
    }

    public AlbumDTO getById(Integer id) {
        Album original = requireOne(id);
        return toDTO(original);
    }

    public Page<AlbumDTO> query(AlbumQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AlbumDTO toDTO(Album original) {
        AlbumDTO bean = new AlbumDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Album requireOne(Integer id) {
        return albumRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
