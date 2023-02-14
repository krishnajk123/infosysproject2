package com.app.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class EntitiesToCases {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "entity_id")
	private Entities entities;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "case_number")
	private Cases cases;
	public EntitiesToCases(Cases cases) {
		super();
		this.cases = cases;
	}
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof EntitiesToCases)) return false;
	        EntitiesToCases that = (EntitiesToCases) o;
	        return Objects.equals(entities.getName(), that.entities.getName()) &&
	                Objects.equals(cases.getCaseNumber(), that.cases.getCaseNumber());
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(entities.getName(), cases.getCaseNumber());
	    }
	
	
	

}
