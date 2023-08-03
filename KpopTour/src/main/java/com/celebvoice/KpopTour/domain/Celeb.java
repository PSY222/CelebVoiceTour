package com.celebvoice.KpopTour.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Celeb {
    @Id
    @Column(name = "celeb_name",nullable = false)
    private String celeb;


    private String celeb_img;

    private String celeb_group;

    @OneToMany(fetch = FetchType.LAZY,
            targetEntity = Location.class,
            mappedBy = "celeb")

    private List<Location> locationList = new ArrayList<>();

}
