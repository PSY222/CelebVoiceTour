package com.celebvoice.KpopTour.service;

import com.celebvoice.KpopTour.repository.CelebRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.celebvoice.KpopTour.domain.Celeb;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CelebService {

    private final CelebRepository celebRepository;

    public Optional<Celeb> getCelebByCelebName(String celebName) {
        // celebRepository에서 findByCelebId 메소드를 호출하여 해당 celebId로 Celeb 객체를 가져옴
        return celebRepository.findById(celebName);
    }


}
