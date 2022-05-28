package com.zjh.sample.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Track")
public class Track implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "TrackId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trackId;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "AlbumId")
    private Integer albumId;

    @Column(name = "MediaTypeId", nullable = false)
    private Integer mediaTypeId;

    @Column(name = "GenreId")
    private Integer genreId;

    @Column(name = "Composer")
    private String composer;

    @Column(name = "Milliseconds", nullable = false)
    private Integer milliseconds;

    @Column(name = "Bytes")
    private Integer bytes;

    @Column(name = "UnitPrice", nullable = false)
    private BigDecimal unitPrice;

}
