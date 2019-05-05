package com.fa.factory.configuration.repository;

import com.fa.factory.configuration.model.ListFactory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<ListFactory, Integer> {
}
