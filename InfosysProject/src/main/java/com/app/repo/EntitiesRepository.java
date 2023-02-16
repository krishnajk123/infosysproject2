package com.app.repo;

import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.entities.Entities;
import com.app.entities.EntitiesToCases;

@Repository
public interface EntitiesRepository extends JpaRepository<Entities, Integer>{
	public List<Entities> findByAllIds(Set<EntitiesToCases> entities);
}
