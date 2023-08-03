package com.celebvoice.KpopTour.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
