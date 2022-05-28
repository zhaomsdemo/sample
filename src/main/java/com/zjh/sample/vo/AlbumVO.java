package com.zjh.sample.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ApiModel("Save ")
public class AlbumVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "albumId can not null")
    private Integer albumId;

    @NotNull(message = "title can not null")
    private String title;

    @NotNull(message = "artistId can not null")
    private Integer artistId;

    private byte[] column1;

}
