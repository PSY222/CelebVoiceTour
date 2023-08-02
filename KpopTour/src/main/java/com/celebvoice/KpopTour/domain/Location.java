package com.celebvoice.KpopTour.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id", nullable = false)
    private Long id;

    private String location;

    private String language;

    @ManyToOne
            (fetch = FetchType.LAZY,
            targetEntity = Celeb.class)
    @JoinColumn(name = "celeb_id")
    private Celeb celeb;

    @Lob
    private Byte[] audio;


}
