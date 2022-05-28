package com.zjh.sample.controller;

import com.zjh.sample.dto.ArtistDTO;
import com.zjh.sample.service.ArtistService;
import com.zjh.sample.vo.ArtistQueryVO;
import com.zjh.sample.vo.ArtistUpdateVO;
import com.zjh.sample.vo.ArtistVO;
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
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody ArtistVO vO) {
        return artistService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        artistService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody ArtistUpdateVO vO) {
        artistService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public ArtistDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return artistService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<ArtistDTO> query(@Valid ArtistQueryVO vO) {
        return artistService.query(vO);
    }
}
