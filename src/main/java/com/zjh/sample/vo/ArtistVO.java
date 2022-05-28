package com.zjh.sample.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ApiModel("Save ")
public class ArtistVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "artistId can not null")
    private Integer artistId;

    private String name;

}
