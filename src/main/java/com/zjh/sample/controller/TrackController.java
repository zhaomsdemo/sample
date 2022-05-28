package com.zjh.sample.controller;

import com.zjh.sample.dto.TrackDTO;
import com.zjh.sample.service.TrackService;
import com.zjh.sample.vo.TrackQueryVO;
import com.zjh.sample.vo.TrackUpdateVO;
import com.zjh.sample.vo.TrackVO;
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
@RequestMapping("/track")
public class TrackController {

    @Autowired
    private TrackService trackService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody TrackVO vO) {
        return trackService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        trackService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody TrackUpdateVO vO) {
        trackService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public TrackDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return trackService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<TrackDTO> query(@Valid TrackQueryVO vO) {
        return trackService.query(vO);
    }
}
