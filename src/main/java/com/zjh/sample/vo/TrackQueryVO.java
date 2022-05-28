package com.zjh.sample.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel("Retrieve by query ")
public class TrackQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer trackId;

    private String name;

    private Integer albumId;

    private Integer mediaTypeId;

    private Integer genreId;

    private String composer;

    private Integer milliseconds;

    private Integer bytes;

    private BigDecimal unitPrice;

}
