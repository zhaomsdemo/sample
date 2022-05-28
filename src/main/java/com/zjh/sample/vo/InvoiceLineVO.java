package com.zjh.sample.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;


@Data
@ApiModel("Save ")
public class InvoiceLineVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "invoiceLineId can not null")
    private Integer invoiceLineId;

    @NotNull(message = "invoiceId can not null")
    private Integer invoiceId;

    @NotNull(message = "trackId can not null")
    private Integer trackId;

    @NotNull(message = "unitPrice can not null")
    private BigDecimal unitPrice;

    @NotNull(message = "quantity can not null")
    private Integer quantity;

}
