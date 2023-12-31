package com.celebvoice.KpopTour.repository;

import java.util.List;
import com.celebvoice.KpopTour.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByLanguage(String language);

}
