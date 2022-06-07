package com.zjh.sample.controller;

import com.zjh.sample.dto.PlaylistDTO;
import com.zjh.sample.service.PlaylistService;
import com.zjh.sample.vo.PlaylistCreateVO;
import com.zjh.sample.vo.PlaylistQueryVO;
import com.zjh.sample.vo.PlaylistUpdateVO;
import com.zjh.sample.vo.PlaylistVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api(tags = "")
@Validated
@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @PostMapping
    @ApiOperation("Save ")
    public ResponseEntity save(@Valid @RequestBody PlaylistCreateVO vO) {
        return playlistService.save(vO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete ")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        playlistService.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update ")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody PlaylistUpdateVO vO) {
        playlistService.update(id, vO);
    }

    @GetMapping("/{id}")
    @ApiOperation("Retrieve by ID ")
    public PlaylistDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return playlistService.getById(id);
    }

    @GetMapping
    @ApiOperation("Retrieve by query ")
    public Page<PlaylistDTO> query(@Valid PlaylistQueryVO vO) {
        return playlistService.query(vO);
    }
}
