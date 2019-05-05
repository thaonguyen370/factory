package com.fa.factory.configuration.repository;

import com.fa.factory.configuration.model.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineRepository extends JpaRepository<Line, Long> {
    List<Line> findAllByFactoryId(Long id);
}
