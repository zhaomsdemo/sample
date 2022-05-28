package com.zjh.sample.controller;

import com.zjh.sample.dto.InvoiceLineDTO;
import com.zjh.sample.service.InvoiceLineService;
import com.zjh.sample.vo.InvoiceLineQueryVO;
import com.zjh.sample.vo.InvoiceLineUpdateVO;
import com.zjh.sample.vo.InvoiceLineVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api(tags = "")
@Validated
@RestController
@RequestMapping("/invoiceLine")
public class InvoiceLineController {

    @Autowired
    private InvoiceLineService invoiceLineService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody InvoiceLineVO vO) {
        return invoiceLineService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        invoiceLineService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody InvoiceLineUpdateVO vO) {
        invoiceLineService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public InvoiceLineDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return invoiceLineService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<InvoiceLineDTO> query(@Valid InvoiceLineQueryVO vO) {
        return invoiceLineService.query(vO);
    }
}
