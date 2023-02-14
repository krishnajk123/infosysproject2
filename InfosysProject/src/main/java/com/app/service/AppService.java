package com.app.service;

import com.app.entities.Cases;
import com.app.entities.Entities;

public interface AppService {
	void save(Entities entities);
	Cases findByCaseNumber(String name);

}
