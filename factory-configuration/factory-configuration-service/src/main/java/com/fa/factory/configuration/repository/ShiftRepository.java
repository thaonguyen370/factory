package com.fa.factory.configuration.repository;

import com.fa.factory.configuration.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShiftRepository extends JpaRepository<Shift, Long> {
    List<Shift> findAllByLineId(Long lineId);
}


