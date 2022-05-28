package com.zjh.sample.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("")
public class MediaTypeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer mediaTypeId;

    private String name;

}
