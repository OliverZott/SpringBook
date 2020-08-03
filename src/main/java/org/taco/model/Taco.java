package org.taco.model;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Taco {
	
	@NotNull
	@Size(min=5, message="Name must be at least 5 letters long.")
	private String tacoName;
	
	@Size(min=2, message="You need to choose at least two ingredients!")
	private List<String> ingredients;

	
	@Override
	public String toString() {
		return super.toString() + ": " + this.getClass() + "; "  + this.getTacoName() + "; " + this.getIngredients() ;
	}
	
	public void setTacoName(String name) {
		this.tacoName = name;
	}

	public  String getTacoName() {
		return tacoName;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	

}
