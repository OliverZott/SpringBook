package org.taco.model;

import java.util.List;
import lombok.Data;

@Data
public class Taco {
	
	private String tacoName;
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
