package com.zjh.sample.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@ApiModel("")
public class InvoiceLineDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer invoiceLineId;

    private Integer invoiceId;

    private Integer trackId;

    private BigDecimal unitPrice;

    private Integer quantity;

}
