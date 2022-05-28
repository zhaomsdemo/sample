package com.zjh.sample.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel("")
public class TrackDTO implements Serializable {
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
