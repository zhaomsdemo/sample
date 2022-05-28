package com.zjh.sample.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Retrieve by query ")
public class PlaylistQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer playlistId;

    private String name;

}
