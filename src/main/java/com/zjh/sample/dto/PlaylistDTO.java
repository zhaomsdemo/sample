package com.zjh.sample.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("")
public class PlaylistDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer playlistId;

    private String name;

}
