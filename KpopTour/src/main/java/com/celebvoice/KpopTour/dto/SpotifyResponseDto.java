package com.celebvoice.KpopTour.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SpotifyResponseDto {
    private String artistName;
    private String title;
    private String albumName;
    private String imageUrl;
    private String previewUrl;
}
