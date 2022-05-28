package com.zjh.sample.vo;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel("Retrieve by query ")
public class InvoiceQueryVO implements Serializable {
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
