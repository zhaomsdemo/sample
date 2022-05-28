package com.zjh.sample.controller;

import com.zjh.sample.dto.EmployeeDTO;
import com.zjh.sample.service.EmployeeService;
import com.zjh.sample.vo.EmployeeQueryVO;
import com.zjh.sample.vo.EmployeeUpdateVO;
import com.zjh.sample.vo.EmployeeVO;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody EmployeeVO vO) {
        return employeeService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        employeeService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody EmployeeUpdateVO vO) {
        employeeService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public EmployeeDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return employeeService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<EmployeeDTO> query(@Valid EmployeeQueryVO vO) {
        return employeeService.query(vO);
    }
}
