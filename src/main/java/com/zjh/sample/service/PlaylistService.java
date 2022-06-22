package com.zjh.sample.service;

import com.zjh.sample.dto.PlaylistDTO;
import com.zjh.sample.entity.Playlist;
import com.zjh.sample.repository.PlaylistRepository;
import com.zjh.sample.vo.PlaylistCreateVO;
import com.zjh.sample.vo.PlaylistQueryVO;
import com.zjh.sample.vo.PlaylistUpdateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Slf4j
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    public ResponseEntity save(PlaylistCreateVO vO) {
        Playlist bean = new Playlist();
        BeanUtils.copyProperties(vO, bean);
        bean = playlistRepository.save(bean);
        return ResponseEntity.ok().body(bean);
    }

    public void delete(Integer id) {
        playlistRepository.deleteById(id);
    }

    public void update(Integer id, PlaylistUpdateVO vO) {
        Playlist bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        playlistRepository.save(bean);
    }

    @Cacheable("PlayLists")
    public PlaylistDTO getById(Integer id) {
        Playlist original = requireOne(id);
        return toDTO(original);
    }

    public Page<PlaylistDTO> query(PlaylistQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private PlaylistDTO toDTO(Playlist original) {
        PlaylistDTO bean = new PlaylistDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Playlist requireOne(Integer id) {
        log.info("Getting PlayList by Id {}", id);
        return playlistRepository.findByPlaylistId(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
