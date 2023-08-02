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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "celeb_id")
    private Long id;

    private String celeb_img;

    @OneToMany(fetch = FetchType.LAZY,
            targetEntity = Location.class,
            mappedBy = "celeb")
    private List<Location> locationList = new ArrayList<>();

}
