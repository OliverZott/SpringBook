package org.taco.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data		// implements missing methods, e.g. constructor (takes all final properties)
@RequiredArgsConstructor		// not necessary (due to @Data) but no harm to include as well
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
public class Ingredient {

	@Id
	private String id;
	private String name;
	private Type type;


	public enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}

	// JPA requires constructor without args
	public Ingredient() {
	}

	public Ingredient(String id, String name, Type type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format(" (OZ) Id: %s; Name: %s", this.name, getClass());
	}

	public Type getType() {
		return this.type;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
}

