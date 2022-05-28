package com.zjh.sample.repository;

import com.zjh.sample.entity.MediaType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MediaTypeRepository extends JpaRepository<MediaType, Integer>, JpaSpecificationExecutor<MediaType> {

}