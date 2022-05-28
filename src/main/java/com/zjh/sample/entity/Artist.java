package com.zjh.sample.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Artist")
public class Artist implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ArtistId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer artistId;

    @Column(name = "Name")
    private String name;

}
