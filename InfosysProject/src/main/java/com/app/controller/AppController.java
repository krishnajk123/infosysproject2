package com.app.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.entities.Cases;
import com.app.entities.Entities;
import com.app.repo.CasesRepository;
import com.app.repo.EntitiesRepository;

import jakarta.persistence.criteria.CriteriaBuilder.Case;

@RestController
@RequestMapping(value="/post")
public class AppController {
	@Autowired
	private CasesRepository casesRepository;
	@Autowired
	private EntitiesRepository entitiesRepository;
	
	@PostMapping(value="/entities")
    public ResponseEntity<Entities> createEntity(@RequestBody Entities entities) {
        Entities savedEntity = entitiesRepository.save(entities);
        URI location = ServletUriComponentsBuilder
                           .fromCurrentRequest()
                           .path("/{id}")
                           .buildAndExpand(savedEntity.getId())
                           .toUri();
        return ResponseEntity.created(location).body(savedEntity);
    }
	
	 @PostMapping(value="/{caseNumber}/entities")
	    public ResponseEntity<Cases> addEntitiesToCase(@PathVariable String caseNumber, @RequestBody List<Long> entityIds) {
	        Cases cases = casesRepository.findByCaseNumber(caseNumber);
	                           
	        List<Entities> entities = entitiesRepository.findByAllIds(entities);
	        
	        cases.setEntities(entities);
	        Cases updatedCase = casesRepository.save(cases);
	        return ResponseEntity.ok(updatedCase);
	    }
	
	
	 @GetMapping(value="/{caseNumber}/entities")
	    public ResponseEntity<Long> getEntityCountForCase(@PathVariable String caseNumber) {
	        Cases aCase = casesRepository.findByCaseNumber(caseNumber);
	                           
	        Long entityCount = aCase.getEntities().size();
	        return ResponseEntity.ok(entityCount);
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	

}
