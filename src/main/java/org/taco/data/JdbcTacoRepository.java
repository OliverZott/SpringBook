package org.taco.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.taco.model.Ingredient;
import org.taco.model.Taco;

@Repository
public class JdbcTacoRepository implements TacoRepository {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public void JdbcTacoRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
		
	}

	@Override
	public Taco save(Taco taco) {
		
		long tacoId = saveTacoInfo(taco);	// ...
		taco.setId(tacoId);		// set Id to taco-object
		
		for (Ingredient ingredient : taco.getIngredients()) {
			saveIngredientToTaco(ingredient, tacoId);
		}
		
		return taco;
	}

	private void saveIngredientToTaco(Ingredient ingredient, long tacoId) {
		// TODO Auto-generated method stub
		
	}

	private long saveTacoInfo(Taco taco) {
		// TODO Auto-generated method stub
		return 0;
	}

}
