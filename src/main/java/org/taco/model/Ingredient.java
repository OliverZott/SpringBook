package org.taco.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data		// implements missing methods, e.g. constructor (takes all final properties)
//@RequiredArgsConstructor		// not necessary (due to @Data) but no harm to include as well
public class Ingredient {
	
	private final String id;
	private final String name;
	private final Type type;
	
	public Ingredient(String id, String name, Type type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
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

