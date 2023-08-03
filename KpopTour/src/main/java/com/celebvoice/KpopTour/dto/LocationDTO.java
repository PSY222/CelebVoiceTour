package com.celebvoice.KpopTour.dto;

import com.celebvoice.KpopTour.domain.Celeb;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDTO {
    private Long id;
    private String location;
    private String language;
    private String audio;
    private Celeb celeb;
}
