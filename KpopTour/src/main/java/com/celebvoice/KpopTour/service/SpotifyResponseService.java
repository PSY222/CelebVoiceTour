package com.celebvoice.KpopTour.service;

// SpotifyService.java
import com.celebvoice.KpopTour.config.SpotifyConfig;
import com.celebvoice.KpopTour.dto.SpotifyResponseDto;
import com.celebvoice.KpopTour.dto.SpotifyResponseMapper;
import com.google.gson.JsonArray;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import com.wrapper.spotify.model_objects.specification.ArtistSimplified;
import com.wrapper.spotify.model_objects.specification.Image;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.data.player.StartResumeUsersPlaybackRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchTracksRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpotifyResponseService {
    private final SpotifyApi spotifyApi;
    private final SpotifyResponseMapper mapper;


    public List<SpotifyResponseDto> search(String keyword) {
        List<SpotifyResponseDto> searchResponseDtoList = new ArrayList<>();

        try {
            // SpotifyConfig에서 액세스 토큰을 얻어옴
            String accessToken = SpotifyConfig.accessToken(spotifyApi);

            // 액세스 토큰을 SpotifyApi에 설정
            spotifyApi.setAccessToken(accessToken);

            // 해당 가수의 곡 정보를 요청함
            SearchTracksRequest searchTrackRequest = spotifyApi.searchTracks(keyword)
                    .limit(5)
                    .build();

//            // 곡을 재생함
//            StartResumeUsersPlaybackRequest startResumeUsersPlaybackRequest = spotifyApi
//                    .startResumeUsersPlayback()
//                    .build();


            Paging<Track> searchResult = searchTrackRequest.execute();
            Track[] tracks = searchResult.getItems();

//            String string = startResumeUsersPlaybackRequest.execute();
//            ClassUtils.convertResourcePathToClassName(string);

            for (Track track : tracks) {
                String title = track.getName();



                AlbumSimplified album = track.getAlbum();
                ArtistSimplified[] artists = album.getArtists();
                String artistName = artists[0].getName();
                String previewUrl = track.getPreviewUrl();

                Image[] images = album.getImages();
                String imageUrl = (images.length > 0) ? images[0].getUrl() : "NO_IMAGE";

                String albumName = album.getName();

                searchResponseDtoList.add(mapper.toSearchDto(artistName, title, albumName, imageUrl,previewUrl));
            }

        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (org.apache.hc.core5.http.ParseException e) {
            throw new RuntimeException(e);
        }
        return searchResponseDtoList;
    }


}