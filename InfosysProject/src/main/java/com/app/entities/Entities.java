package com.app.entities;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class Entities {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private String companyName;
	private boolean isCompany;
	private Date createdAt;
	@OneToMany(mappedBy = "entities", cascade = CascadeType.ALL)
	private Set<EntitiesToCases> entitiesToCases;
	
	public Entities(String name, EntitiesToCases...  entitiesToCases) {
        this.name = name;
        for(EntitiesToCases EntitiesToCases :  entitiesToCases) EntitiesToCases.setEntities(this);
        this. entitiesToCases = Stream.of( entitiesToCases).collect(Collectors.toSet());

	}
}
