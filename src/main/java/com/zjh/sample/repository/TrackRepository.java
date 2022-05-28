package com.zjh.sample.repository;

import com.zjh.sample.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TrackRepository extends JpaRepository<Track, Integer>, JpaSpecificationExecutor<Track> {

}