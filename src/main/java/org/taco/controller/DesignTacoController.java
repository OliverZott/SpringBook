package org.taco.controller;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

import org.taco.model.Ingredient;
import org.taco.model.Taco;
import org.taco.model.Ingredient.Type;


@Slf4j		// Creating logger
@Controller		// annotation for component-search, which creates instance as Bean
@RequestMapping("/design")		// specifies character of class (all request with path "/design")
public class DesignTacoController {
	
	// Logger (java book p.930)
	private static final Logger log = Logger.getLogger(DesignTacoController.class.getName());
	
	
	@GetMapping
	public static String showDesignForm(Model model) 
	{	
		/*
		 * If creating List without Array.asList method: 
		 * List<Ingredient> ingredients0 = new ArrayList<Ingredient>()
		 * ingredients0.add(new Ingredient("FLTO", "test", Type.WRAP));
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
		
		model.addAttribute("taco", new Taco());
		
		return "design";
	}
	
	
	private static List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
	    return ingredients
	              .stream()		// create stream from Object-List 
	              .filter(x -> x.getType().equals(type))		// 
	              .collect(Collectors.toList());
	  }
	
	
	@PostMapping
	public  String processDesign(@Valid Taco taco, Errors errors) {			
		if(errors.hasErrors()) {
			return "design";
		}
		
		// ToDo: persistence - save taco creation 
		log.info("PPPPProcessing design: " + taco);
		
		return "redirect:/orders/current";				// "redirect:" to forward user to new page
	}
}

