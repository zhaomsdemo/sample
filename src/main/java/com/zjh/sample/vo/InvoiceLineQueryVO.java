package com.zjh.sample.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel("Retrieve by query ")
public class InvoiceLineQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer invoiceLineId;

    private Integer invoiceId;

    private Integer trackId;

    private BigDecimal unitPrice;

    private Integer quantity;

}
