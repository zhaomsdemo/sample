package com.zjh.sample.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ApiModel("Save ")
public class PlaylistVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "playlistId can not null")
    private Integer playlistId;

    private String name;

}
