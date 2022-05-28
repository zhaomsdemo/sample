package com.zjh.sample.controller;

import com.zjh.sample.dto.CustomerDTO;
import com.zjh.sample.service.CustomerService;
import com.zjh.sample.vo.CustomerQueryVO;
import com.zjh.sample.vo.CustomerUpdateVO;
import com.zjh.sample.vo.CustomerVO;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody CustomerVO vO) {
        return customerService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        customerService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody CustomerUpdateVO vO) {
        customerService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public CustomerDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return customerService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<CustomerDTO> query(@Valid CustomerQueryVO vO) {
        return customerService.query(vO);
    }
}
