package org.taco.model;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Taco {
	
	@NotNull
	@Size(min=5, message="Name must be at least 5 letters long.")
	private String tacoName;
	@Size(min=1, message="You need to choose at least one ingredient.")
	private List<String> tacoIngredients;

	public void setTacoName(String name) {
		this.tacoName = name;
	}

	public  String getTacoName() {
		return tacoName;
	}

	public List<String> getIngredients() {
		return tacoIngredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.tacoIngredients = ingredients;
	}
	
	

}
