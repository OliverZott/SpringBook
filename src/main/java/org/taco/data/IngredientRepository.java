package org.taco.data;

import org.taco.model.Ingredient;

public interface IngredientRepository {
	
	Iterable<Ingredient> findAll();
	
	Ingredient findOne(String id);
	
	Ingredient save(Ingredient ingredient);	

}
