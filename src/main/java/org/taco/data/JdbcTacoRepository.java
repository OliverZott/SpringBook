package org.taco.data;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import org.taco.model.Ingredient;
import org.taco.model.Taco;

/**
 * Class handles 
 *  - taco insertion into "Taco" database-table  (name, creatdAt)
 *  - tace ADN ingredient insertion into "Taco_Ingredients" database-table (id, ingredient)
 *  
 *  
 * @author olli
 *
 */
@Repository
public class JdbcTacoRepository implements TacoRepository {
	
	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcTacoRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
		
	}

	@Override
	public Taco save(Taco taco) {
		long tacoId = saveTacoInfo(taco);	// returns tacoId
		taco.setId(tacoId);					// set Id to taco-object
		
		for (Ingredient ingredient : taco.getIngredients()) {
			saveIngredientToTaco(ingredient, tacoId);
		}
		return taco;
	}

	/*
	 * Function to assign taco & ingredients to linking-table (taco_ingredients)
	 */
	private void saveIngredientToTaco(Ingredient ingredient, long tacoId) {
		jdbc.update(
				"INSERT INTO Taco_Ingredients (taco, ingredient) VALUES (?, ?)",
				tacoId,
				ingredient.getId());
	}

	/*
	 * Function sets taco creation date/time and gives/retrieves tacoId from db!
	 */
	private long saveTacoInfo(Taco taco) {
		taco.setCreatedAt(new Date());				// set taco creation time/date									
		PreparedStatementCreator psc = new PreparedStatementCreatorFactory(
				"INSERT INTO Taco (name, createdAt) VALUES (?, ?)",
				Types.VARCHAR, Types.TIMESTAMP
				).newPreparedStatementCreator(
						Arrays.asList(
								taco.getTacoName(),
								new Timestamp(taco.getCreatedAt().getTime())		// get timestamp from creation date
								)
						);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbc.update(psc, keyHolder);
		
		return keyHolder.getKey().longValue();
	}

}
