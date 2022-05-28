package com.zjh.sample.service;

import com.zjh.sample.dto.TrackDTO;
import com.zjh.sample.entity.Track;
import com.zjh.sample.repository.TrackRepository;
import com.zjh.sample.vo.TrackQueryVO;
import com.zjh.sample.vo.TrackUpdateVO;
import com.zjh.sample.vo.TrackVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TrackService {

    @Autowired
    private TrackRepository trackRepository;

    public Integer save(TrackVO vO) {
        Track bean = new Track();
        BeanUtils.copyProperties(vO, bean);
        bean = trackRepository.save(bean);
        return bean.getTrackId();
    }

    public void delete(Integer id) {
        trackRepository.deleteById(id);
    }

    public void update(Integer id, TrackUpdateVO vO) {
        Track bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        trackRepository.save(bean);
    }

    public TrackDTO getById(Integer id) {
        Track original = requireOne(id);
        return toDTO(original);
    }

    public Page<TrackDTO> query(TrackQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private TrackDTO toDTO(Track original) {
        TrackDTO bean = new TrackDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Track requireOne(Integer id) {
        return trackRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
