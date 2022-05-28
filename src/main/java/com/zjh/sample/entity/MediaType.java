package com.zjh.sample.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "MediaType")
public class MediaType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "MediaTypeId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mediaTypeId;

    @Column(name = "Name")
    private String name;

}