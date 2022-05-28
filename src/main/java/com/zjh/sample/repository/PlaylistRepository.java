package com.zjh.sample.repository;

import com.zjh.sample.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer>, JpaSpecificationExecutor<Playlist> {

}