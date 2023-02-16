package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.entities.Cases;

@Repository
public interface CasesRepository extends JpaRepository<Cases, Integer> {
	 public Cases findByCaseNumber(String name);
}
