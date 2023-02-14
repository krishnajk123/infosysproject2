package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Cases;

public interface CasesRepository extends JpaRepository<Cases, Integer> {
	 public Cases findByCaseNumber(String name);
}
