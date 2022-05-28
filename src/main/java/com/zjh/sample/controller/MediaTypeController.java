package com.zjh.sample.controller;

import com.zjh.sample.dto.MediaTypeDTO;
import com.zjh.sample.service.MediaTypeService;
import com.zjh.sample.vo.MediaTypeCreateVO;
import com.zjh.sample.vo.MediaTypeQueryVO;
import com.zjh.sample.vo.MediaTypeUpdateVO;
import com.zjh.sample.vo.MediaTypeVO;
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
@RequestMapping("/mediaType")
public class MediaTypeController {

    @Autowired
    private MediaTypeService mediaTypeService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody MediaTypeCreateVO vO) {
        return mediaTypeService.create(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        mediaTypeService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody MediaTypeUpdateVO vO) {
        mediaTypeService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public MediaTypeDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return mediaTypeService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<MediaTypeDTO> query(@Valid MediaTypeQueryVO vO) {
        return mediaTypeService.query(vO);
    }
}
