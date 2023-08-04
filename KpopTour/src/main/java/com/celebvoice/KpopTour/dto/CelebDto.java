package com.celebvoice.KpopTour.dto;

import com.celebvoice.KpopTour.domain.Celeb;
import com.celebvoice.KpopTour.domain.Location;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CelebDto {
    private String celeb;
    private String celebImg;
    private String celebGroup;

}
