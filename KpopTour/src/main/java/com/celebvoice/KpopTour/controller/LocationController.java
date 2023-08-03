package com.celebvoice.KpopTour.controller;

import com.celebvoice.KpopTour.dto.LocationDTO;
import com.celebvoice.KpopTour.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<LocationDTO> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/celeb/{language}")
    public ResponseEntity<List<LocationDTO>> getLocationsByLanguage(@PathVariable String language) {
        List<LocationDTO> locations = locationService.getCelebByLanguage(language);
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public LocationDTO getLocationById(@PathVariable Long id) {
        return locationService.getLocationById(id);
    }

}