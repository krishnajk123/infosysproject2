package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.entities.Cases;
import com.app.entities.Entities;
import com.app.repo.CasesRepository;
import com.app.repo.EntitiesRepository;
import com.app.service.AppService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AppServiceImpl implements AppService {

	@Autowired
	private CasesRepository casesRepository;

	@Autowired
	private EntitiesRepository entitiesRepository;

	@Override
	public void save(Entities entities) {
		entitiesRepository.save(entities);
	}

	@Override
	public Cases findByCaseNumber(String name) {
		return casesRepository.findByCaseNumber(name);
	}
}
