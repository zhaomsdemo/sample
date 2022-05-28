package com.zjh.sample.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@ApiModel("Save ")
public class MediaTypeCreateVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

}
