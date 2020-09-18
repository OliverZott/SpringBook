/*
package org.taco.data;

import org.taco.model.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

*/
/**
 * Repository for Ingredient-Model
 * 
 * @author Oliver Zott
 *
 *//*

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

	private final JdbcTemplate jdbc;
	
	@Autowired
	public JdbcIngredientRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public Iterable<Ingredient> findAll() {
		return jdbc.query("select id, name, type from Ingredient",
				this::mapRowToIngredient);
	}

	@Override
	public Ingredient findOne(String id) {
		return jdbc.queryForObject(
				"select id, name, type from Ingredient where id=?",
				this::mapRowToIngredient, 
				id);
	}

	*/
/*
	 * Used as MethodReference to RowMapper-Parameter in "findAll" and "findOneById" methods
	 * (query / queryForObject)
	 * For explicit rowMapper see spring-book page 67
	 *//*

	private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
		return new Ingredient(
				rs.getString("id"), 
		        rs.getString("name"),
		        Ingredient.Type.valueOf(rs.getString("type")));
		}
	
	  @Override
	  public Ingredient save(Ingredient ingredient) {
	    jdbc.update(
	        "insert into Ingredient (id, name, type) values (?, ?, ?)",
	        ingredient.getId(), 
	        ingredient.getName(),
	        ingredient.getType().toString());
	    return ingredient;
	  }	
}

*/
