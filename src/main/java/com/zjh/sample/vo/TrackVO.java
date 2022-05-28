package com.zjh.sample.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;


@Data
@ApiModel("Save ")
public class TrackVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "trackId can not null")
    private Integer trackId;

    @NotNull(message = "name can not null")
    private String name;

    private Integer albumId;

    @NotNull(message = "mediaTypeId can not null")
    private Integer mediaTypeId;

    private Integer genreId;

    private String composer;

    @NotNull(message = "milliseconds can not null")
    private Integer milliseconds;

    private Integer bytes;

    @NotNull(message = "unitPrice can not null")
    private BigDecimal unitPrice;

}
