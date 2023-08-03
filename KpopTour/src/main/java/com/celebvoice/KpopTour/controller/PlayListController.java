package com.celebvoice.KpopTour.controller;


import com.celebvoice.KpopTour.dto.SpotifyResponseDto;
import com.celebvoice.KpopTour.service.SpotifyResponseService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@Controller
@RequiredArgsConstructor
@RequestMapping("kceleb")
public class PlayListController {
    private static final Logger logger = LoggerFactory.getLogger(PlayListController.class);

    private final SpotifyResponseService spotifyService;

    @GetMapping("search")
    public String search(Model model, @RequestParam("keyword") String keyword) {

        List<SpotifyResponseDto> spotifyResponseDtoList = spotifyService.search(keyword);

        model.addAttribute(spotifyResponseDtoList);

        return "audioPage";
    }

}