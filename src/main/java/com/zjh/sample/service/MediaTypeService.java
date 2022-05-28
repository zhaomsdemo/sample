package com.zjh.sample.service;

import com.zjh.sample.dto.MediaTypeDTO;
import com.zjh.sample.entity.MediaType;
import com.zjh.sample.repository.MediaTypeRepository;
import com.zjh.sample.vo.MediaTypeCreateVO;
import com.zjh.sample.vo.MediaTypeQueryVO;
import com.zjh.sample.vo.MediaTypeUpdateVO;
import com.zjh.sample.vo.MediaTypeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MediaTypeService {

    @Autowired
    private MediaTypeRepository mediaTypeRepository;

    public Integer create(MediaTypeCreateVO vO) {
        MediaType bean = new MediaType();
        BeanUtils.copyProperties(vO, bean);
        bean = mediaTypeRepository.save(bean);
        return bean.getMediaTypeId();
    }

    public Integer save(MediaTypeVO vO) {
        MediaType bean = new MediaType();
        BeanUtils.copyProperties(vO, bean);
        bean = mediaTypeRepository.save(bean);
        return bean.getMediaTypeId();
    }

    public void delete(Integer id) {
        mediaTypeRepository.deleteById(id);
    }

    public void update(Integer id, MediaTypeUpdateVO vO) {
        MediaType bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        mediaTypeRepository.save(bean);
    }

    public MediaTypeDTO getById(Integer id) {
        MediaType original = requireOne(id);
        return toDTO(original);
    }

    public Page<MediaTypeDTO> query(MediaTypeQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MediaTypeDTO toDTO(MediaType original) {
        MediaTypeDTO bean = new MediaTypeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MediaType requireOne(Integer id) {
        return mediaTypeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
