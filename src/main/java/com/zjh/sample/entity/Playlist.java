package com.zjh.sample.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Playlist")
public class Playlist implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PlaylistId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playlistId;

    @Column(name = "Name")
    private String name;

}
