package org.taco.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

import org.taco.Ingredient;
import org.taco.Taco;
import org.taco.Ingredient.Type;


@Slf4j		// Creating logger
@Controller		// annotation for component-search, which creates instance as Bean
@RequestMapping("/design")		// specifies character of class (all request with path "/design")
public class DesignTacoController {
	
	@GetMapping
	public static String showDesignForm(Model model) 
	{
		
		/*
		 *If creating List without Array.asList method: 
		List<Ingredient> ingredients0 = new ArrayList<Ingredient>();
		ingredients0.add(new Ingredient("FLTO", "test", Type.WRAP));
		*/
		
		List<Ingredient> ingredients = Arrays.asList(		// Creating List from array of ingredients
				new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
				new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
				new Ingredient("test", "test", Type.WRAP),
				new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
				new Ingredient("CARN", "Carnitas", Type.PROTEIN),
				new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
				new Ingredient("LETC", "Lettuce", Type.VEGGIES),
				new Ingredient("CHED", "Cheddar", Type.CHEESE),
				new Ingredient("JACK", "Monterry Jack", Type.CHEESE),
				new Ingredient("SLSA", "Salsa", Type.SAUCE),
				new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
				);
		
		Ingredient.Type[] types = Ingredient.Type.values();	// Create array of ingredient types. Enum-method: values() returns array
		System.out.println(types);
		
		// checks what "types" appear in "ingredients" list, to render only corresponding in html
		// so e.g. "wrap" is associated with a collection of wrap-type ingredients
		for (Type type : types) {
			  model.addAttribute(
					  type.toString().toLowerCase(),
					  filterByType(ingredients, type)
					  );
			}
		
		model.addAttribute("design", new Taco());
		
		return "design";
	}
	
	
	private static List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
	    return ingredients
	              .stream()		// create stream from Object-List 
	              .filter(x -> x.getType().equals(type))		// 
	              .collect(Collectors.toList());
	  }
	
}
