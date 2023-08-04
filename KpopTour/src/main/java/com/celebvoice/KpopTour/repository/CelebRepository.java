package com.celebvoice.KpopTour.repository;

import com.celebvoice.KpopTour.domain.Celeb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CelebRepository extends JpaRepository<Celeb,String> {

    Optional<Celeb> findById(String celebName);


}
