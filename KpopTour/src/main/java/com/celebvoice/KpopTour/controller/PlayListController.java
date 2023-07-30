package com.celebvoice.KpopTour.controller;

// SearchController.java
import com.celebvoice.KpopTour.dto.SpotifyResponseDto;
import com.celebvoice.KpopTour.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.convert.spi.ConverterAutoApplyHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class PlayListController {
    private final PlaylistService spotifyService;


    @GetMapping("/search")
    public List<SpotifyResponseDto> search(@RequestParam("keyword") String keyword) {

        return spotifyService.search(keyword);
    }
}