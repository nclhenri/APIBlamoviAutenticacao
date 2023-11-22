package com.blamovi.apiblamovi.controllers;

import com.blamovi.apiblamovi.models.UsuarioModel;
import com.blamovi.apiblamovi.models.VideoModel;
import com.blamovi.apiblamovi.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/videos", produces = {"application/json"})
public class VideoController {

    @Autowired
    VideoRepository videoRepository;

    @GetMapping
    public ResponseEntity<List<VideoModel>> listarVideos(){
        return ResponseEntity.status(HttpStatus.OK).body(videoRepository.findAll());
    }
}
