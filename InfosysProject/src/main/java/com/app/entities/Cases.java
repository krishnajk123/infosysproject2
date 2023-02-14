package com.app.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Entity
@Setter
@Getter
public class Cases {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String caseNumber;
	private Date createdAt;
	@OneToMany(mappedBy = "entities", cascade = CascadeType.ALL)
	private Set<EntitiesToCases> entitiesToCases;
	
	

}
