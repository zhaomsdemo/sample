package com.zjh.sample.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "Invoice")
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "InvoiceId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invoiceId;

    @Column(name = "CustomerId", nullable = false)
    private Integer customerId;

    @Column(name = "InvoiceDate", nullable = false)
    private Date invoiceDate;

    @Column(name = "BillingAddress")
    private String billingAddress;

    @Column(name = "BillingCity")
    private String billingCity;

    @Column(name = "BillingState")
    private String billingState;

    @Column(name = "BillingCountry")
    private String billingCountry;

    @Column(name = "BillingPostalCode")
    private String billingPostalCode;

    @Column(name = "Total", nullable = false)
    private BigDecimal total;

}
