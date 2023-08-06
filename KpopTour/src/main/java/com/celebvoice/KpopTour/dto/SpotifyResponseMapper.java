package com.celebvoice.KpopTour.dto;

import org.springframework.stereotype.Component;

@Component
public class SpotifyResponseMapper {
    public SpotifyResponseDto toSearchDto(String artistName, String title, String albumName, String imageUrl, String previewUrl) {
        return SpotifyResponseDto.builder()
                .artistName(artistName)
                .title(title)
                .albumName(albumName)
                .imageUrl(imageUrl)
                .previewUrl(previewUrl)
                .build();
    }
}
