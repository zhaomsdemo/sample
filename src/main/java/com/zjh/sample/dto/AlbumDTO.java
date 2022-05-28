package com.zjh.sample.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("")
public class AlbumDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer albumId;

    private String title;

    private Integer artistId;

    private byte[] column1;

}
