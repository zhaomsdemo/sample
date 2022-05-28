package com.zjh.sample.service;

import com.zjh.sample.dto.PlaylistTrackDTO;
import com.zjh.sample.entity.PlaylistTrack;
import com.zjh.sample.repository.PlaylistTrackRepository;
import com.zjh.sample.vo.PlaylistTrackQueryVO;
import com.zjh.sample.vo.PlaylistTrackUpdateVO;
import com.zjh.sample.vo.PlaylistTrackVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PlaylistTrackService {

    @Autowired
    private PlaylistTrackRepository playlistTrackRepository;

    public Integer save(PlaylistTrackVO vO) {
        PlaylistTrack bean = new PlaylistTrack();
        BeanUtils.copyProperties(vO, bean);
        bean = playlistTrackRepository.save(bean);
        return bean.getPlaylistTrackId();
    }

    public void delete(Integer id) {
        playlistTrackRepository.deleteById(id);
    }

    public void update(Integer id, PlaylistTrackUpdateVO vO) {
        PlaylistTrack bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        playlistTrackRepository.save(bean);
    }

    public PlaylistTrackDTO getById(Integer id) {
        PlaylistTrack original = requireOne(id);
        return toDTO(original);
    }

    public Page<PlaylistTrackDTO> query(PlaylistTrackQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PlaylistTrackDTO toDTO(PlaylistTrack original) {
        PlaylistTrackDTO bean = new PlaylistTrackDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private PlaylistTrack requireOne(Integer id) {
        return playlistTrackRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
