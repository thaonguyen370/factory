package com.fa.factory.configuration.repository;

import com.fa.factory.configuration.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

    Station findByPositionAndLineId(int position, long lineId);
}
