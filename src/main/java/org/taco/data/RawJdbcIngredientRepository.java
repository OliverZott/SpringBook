package org.taco.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.taco.model.Ingredient;


public class RawJdbcIngredientRepository implements IngredientRepository {
	
	private DataSource dataSource;
	
	// TODO: smth missing
	
	
	@Override
	public Ingredient findOne(String id) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(
					"select id, name, type from Ingredient where id=?");
			statement.setString(1, id);
			resultSet = statement.executeQuery();
			Ingredient ingredient = null;
			
			if(resultSet.next()) {												// "true" if the new current row is valid
				ingredient = new Ingredient(
						resultSet.getString("id"),
						resultSet.getString("name"),
						Ingredient.Type.valueOf(resultSet.getString("type")));				
			}
			return ingredient;		
			
		} catch (SQLException e) {
			// TODO: stuff
		} finally {
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {}				
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {}
			}
		}
				
		return null;
	}

	
	@Override
	public Iterable<Ingredient> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public Ingredient save(Ingredient ingredient) {
		// TODO Auto-generated method stub
		return null;
	}

}
