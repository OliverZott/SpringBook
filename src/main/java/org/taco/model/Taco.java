package org.taco.model;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Taco {
	
	private Long id;
	private Date createdAt;
	
	@NotNull
	@Size(min=5, message="Name must be at least 5 letters long.")
	private String tacoName;
	
	@Size(min=2, message="You need to choose at least two ingredients!")
	private List<Ingredient> ingredients;

	
	@Override
	public String toString() {
		return super.toString() + ": " + this.getClass() + "; "  + this.getTacoName() + "; ";
	}
	
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date placedAt) {
		this.createdAt = placedAt;
	}

	public void setTacoName(String name) {
		this.tacoName = name;
	}

	public  String getTacoName() {
		return tacoName;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}


}
