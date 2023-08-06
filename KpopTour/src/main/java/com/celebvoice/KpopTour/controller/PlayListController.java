package com.celebvoice.KpopTour.controller;


import com.celebvoice.KpopTour.domain.Celeb;
import com.celebvoice.KpopTour.domain.Location;
import com.celebvoice.KpopTour.dto.SpotifyResponseDto;
import com.celebvoice.KpopTour.service.CelebService;
import com.celebvoice.KpopTour.service.SpotifyResponseService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
@RequestMapping("kceleb")
public class PlayListController {
    private static final Logger logger = LoggerFactory.getLogger(PlayListController.class);

    private final SpotifyResponseService spotifyService;
    private final CelebService celebService;

    @GetMapping("search")
    public String search(Model model, @RequestParam("keyword") String keyword,
                         @RequestParam("language") String language,
                         @RequestParam("location") String location) {

        List<SpotifyResponseDto> spotifyResponseDtoList = spotifyService.search(keyword);
        Optional<Celeb> celeb = celebService.getCelebByCelebName(keyword);
        String celebImg = celeb.get().getCeleb_img();
        String celebAudio = null;

        for (Location loc : celeb.get().getLocationList()) {
            if (loc.getCeleb().getCeleb().equals(keyword) && loc.getLanguage().equals(language) && loc.getLocation().equals(location)) {
                celebAudio = loc.getAudio();
                break;
            }else{
                celebAudio ="/audio/jennie_eng.wav";
            }
        }
        model.addAttribute(spotifyResponseDtoList);
        model.addAttribute("celebImage",celebImg);
        model.addAttribute("selectedAudio", celebAudio);
        model.addAttribute("selectedKeyword", keyword);
        model.addAttribute("selectedLanguage", language);
        model.addAttribute("selectedCelebGroup", keyword);
        model.addAttribute("selectedLocation", location);

        return "audioPage";
    }



}