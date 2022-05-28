package com.zjh.sample.repository;

import com.zjh.sample.entity.PlaylistTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlaylistTrackRepository extends JpaRepository<PlaylistTrack, Integer>, JpaSpecificationExecutor<PlaylistTrack> {

}