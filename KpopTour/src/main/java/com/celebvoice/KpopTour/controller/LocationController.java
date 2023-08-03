package com.celebvoice.KpopTour.controller;

import com.celebvoice.KpopTour.domain.Celeb;
import com.celebvoice.KpopTour.domain.Location;
import com.celebvoice.KpopTour.repository.CelebRepository;
import com.celebvoice.KpopTour.service.CelebService;
import com.celebvoice.KpopTour.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("kceleb")
public class LocationController {

    private final LocationService locationService;
    private final CelebService celebService;
    private final CelebRepository celebRepository;

//    @GetMapping("/{language}")
    @GetMapping("{language}")
    public String getLocationsByLanguage(
//            @RequestParam(name = "language") String language,
            @PathVariable(name = "language") String language,
            Model model
            )
    {
        List<Location> locationList = locationService.getLocationByLanguage(language);
        List<Optional<Celeb>> celebList = new ArrayList<>();
        for(Location location :locationList){
            System.out.println(location.getCeleb().getCeleb());
            System.out.println(String.valueOf(location.getCeleb()));
            Optional<Celeb> celeb = celebService.getCelebByCelebName(location.getCeleb().getCeleb());
            celebList.add(celeb);
        }


        model.addAttribute("celebList",celebList);
        return "startPage";
    }
//
//    @GetMapping("/{id}")
//    public LocationDto getLocationById(@PathVariable Long id) {
//        return locationService.getLocationById(id);
//    }



}