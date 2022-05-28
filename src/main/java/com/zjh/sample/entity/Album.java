package com.zjh.sample.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Album")
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "AlbumId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer albumId;

    @Column(name = "Title", nullable = false)
    private String title;

    @Column(name = "ArtistId", nullable = false)
    private Integer artistId;

    @Column(name = "Column1")
    private byte[] column1;

}
