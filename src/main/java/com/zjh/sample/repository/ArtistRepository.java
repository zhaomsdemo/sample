package com.zjh.sample.repository;

import com.zjh.sample.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArtistRepository extends JpaRepository<Artist, Integer>, JpaSpecificationExecutor<Artist> {

}