package com.celebvoice.KpopTour.service;

import com.celebvoice.KpopTour.domain.Location;
import com.celebvoice.KpopTour.dto.LocationDto;
import com.celebvoice.KpopTour.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;


    public List<LocationDto> getAllLocations() {
        List<Location> locations = locationRepository.findAll();
        return locations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

//    public List<LocationDto> getCelebByLanguage(String language) {
//        List<Location> locations = locationRepository.findByLanguage(language);
//        return locations.stream().map(this::convertToDTO).collect(Collectors.toList());
//    }

    public List<Location> getLocationByLanguage(String language){
        List<Location> locationList = locationRepository.findByLanguage(language);
        return locationList;
    }

    public LocationDto getLocationById(Long id) {
        Optional<Location> locationOptional = locationRepository.findById(id);
        return locationOptional.map(this::convertToDTO).orElse(null);
    }


    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
    private LocationDto convertToDTO(Location location) {
        LocationDto locationDTO = new LocationDto();
        locationDTO.setId(location.getId());
        locationDTO.setLocation(location.getLocation());
        locationDTO.setLanguage(location.getLanguage());
        locationDTO.setCeleb(location.getCeleb());
        locationDTO.setAudio(location.getAudio());
        // Set other fields as needed

        return locationDTO;
    }

    // Helper method to convert LocationDTO to Location entity
    private Location convertToEntity(LocationDto locationDTO) {
        Location location = new Location();
        location.setId(locationDTO.getId());
        location.setLocation(locationDTO.getLocation());
        location.setLanguage(locationDTO.getLanguage());
        location.setCeleb(locationDTO.getCeleb());
        location.setAudio(locationDTO.getAudio());
        // Set other fields as needed

        return location;
    }


}

