package com.zjh.sample.controller;

import com.zjh.sample.dto.GenreDTO;
import com.zjh.sample.service.GenreService;
import com.zjh.sample.vo.GenreQueryVO;
import com.zjh.sample.vo.GenreUpdateVO;
import com.zjh.sample.vo.GenreVO;
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
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody GenreVO vO) {
        return genreService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        genreService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody GenreUpdateVO vO) {
        genreService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public GenreDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return genreService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<GenreDTO> query(@Valid GenreQueryVO vO) {
        return genreService.query(vO);
    }
}
