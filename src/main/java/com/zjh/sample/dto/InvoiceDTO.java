package com.zjh.sample.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel("")
public class InvoiceDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer invoiceId;

    private Integer customerId;

    private Date invoiceDate;

    private String billingAddress;

    private String billingCity;

    private String billingState;

    private String billingCountry;

    private String billingPostalCode;

    private BigDecimal total;

}
