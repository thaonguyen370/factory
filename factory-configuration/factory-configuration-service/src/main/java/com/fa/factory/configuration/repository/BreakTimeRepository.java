package com.fa.factory.configuration.repository;

import com.fa.factory.configuration.model.BreakTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreakTimeRepository extends JpaRepository<BreakTime, Long> {
}
