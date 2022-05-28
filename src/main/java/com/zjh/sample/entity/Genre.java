package com.zjh.sample.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Genre")
public class Genre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "GenreId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer genreId;

    @Column(name = "Name")
    private String name;

}
