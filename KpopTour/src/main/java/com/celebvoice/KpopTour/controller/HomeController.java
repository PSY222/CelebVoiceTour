package com.celebvoice.KpopTour.controller;

import com.celebvoice.KpopTour.domain.Celeb;
import com.celebvoice.KpopTour.domain.Location;
import com.celebvoice.KpopTour.service.CelebService;
import com.celebvoice.KpopTour.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/kceleb")
    public String kcelebMain(){
        return "startPage";
    }

    @GetMapping("/kceleb/audio")
    public String kcelebAudio(){
        return "audioPage";
    }


    @GetMapping("/test")
    public String test(){
        return "test";
    }

}
