package com.fa.factory.configuration.repository;

import com.fa.factory.configuration.model.PauseTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PausetimeRepository extends JpaRepository<PauseTime, Long> {
}
