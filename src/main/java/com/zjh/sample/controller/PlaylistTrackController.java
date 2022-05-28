package com.zjh.sample.controller;

import com.zjh.sample.dto.PlaylistTrackDTO;
import com.zjh.sample.service.PlaylistTrackService;
import com.zjh.sample.vo.PlaylistTrackQueryVO;
import com.zjh.sample.vo.PlaylistTrackUpdateVO;
import com.zjh.sample.vo.PlaylistTrackVO;
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
@RequestMapping("/playlistTrack")
public class PlaylistTrackController {

    @Autowired
    private PlaylistTrackService playlistTrackService;

    @PostMapping
    @ApiOperation("Save ")
    public String save(@Valid @RequestBody PlaylistTrackVO vO) {
        return playlistTrackService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        playlistTrackService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody PlaylistTrackUpdateVO vO) {
        playlistTrackService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public PlaylistTrackDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return playlistTrackService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<PlaylistTrackDTO> query(@Valid PlaylistTrackQueryVO vO) {
        return playlistTrackService.query(vO);
    }
}
