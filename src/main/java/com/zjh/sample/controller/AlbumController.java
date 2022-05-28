package com.zjh.sample.controller;

import com.zjh.sample.dto.AlbumDTO;
import com.zjh.sample.service.AlbumService;
import com.zjh.sample.vo.AlbumQueryVO;
import com.zjh.sample.vo.AlbumUpdateVO;
import com.zjh.sample.vo.AlbumVO;
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
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody AlbumVO vO) {
        return albumService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        albumService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody AlbumUpdateVO vO) {
        albumService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public AlbumDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return albumService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<AlbumDTO> query(@Valid AlbumQueryVO vO) {
        return albumService.query(vO);
    }
}
