package com.zjh.sample.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "PlaylistTrack")
public class PlaylistTrack implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PlaylistTrackId", nullable = false)
    private Integer playlistTrackId;

    @Column(name = "PlaylistId", nullable = false)
    private Integer playlistId;

    @Column(name = "TrackId", nullable = false)
    private Integer trackId;

}
