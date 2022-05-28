package com.zjh.sample.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("")
public class ArtistDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer artistId;

    private String name;

}
