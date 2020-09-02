package org.taco.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;

import org.taco.data.IngredientRepository;
import org.taco.data.TacoRepository;
import org.taco.model.Ingredient;
import org.taco.model.Ingredient.Type;
import org.taco.model.Order;
import org.taco.model.Taco;

//@Slf4j							// Creating logger
@Controller						// annotation for component-search, which creates instance as Bean
@RequestMapping("/design")		// specifies character of class (all request with path "/design")
@SessionAttributes("order")
public class DesignTacoController {
	
	private static final Logger log = Logger.getLogger(DesignTacoController.class.getName());
	private final IngredientRepository ingredientRepo;
	private final TacoRepository designRepo;
	
	@Autowired
	public DesignTacoController(
			IngredientRepository ingredientRepo,
			TacoRepository designRepo) {
		this.ingredientRepo = ingredientRepo;
		this.designRepo = designRepo;
	}
	
	@ModelAttribute(name = "order")
	public Order order() {
		return new Order();
	}
	
	@ModelAttribute(name = "taco")
	public Taco taco() {
		return new Taco();
	}
	
	@GetMapping
	public  String showDesignForm(Model model) 
	{	
		List<Ingredient> ingredients = new ArrayList<>();
		ingredientRepo.findAll().forEach(i -> ingredients.add(i));
		
		Type[] types = Ingredient.Type.values();	// Create array of ingredient types. Enum-method: values() return all values present inside enum
		
		/*
		 * Fooling around with streams 
		 */
		System.out.println("PRINT: " + Arrays.toString(types));
		Stream<Type> stream = Arrays.stream(types);
		stream.forEach(System.out::println);
		
		/*
		 * checks what "types" appear in "ingredients" list, to render only corresponding in HTML
		 * so e.g. "wrap" is associated with a collection of wrap-type ingredients
		 */
		for (Type type : types) {
			  model.addAttribute(
					  type.toString().toLowerCase(),
					  filterByType(ingredients, type)
					  );
			}
		
		model.addAttribute("design", new Taco());
		
		return "design";		// refers to HTML-template
	}
	
	
	private static List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
	    return ingredients
	              .stream()		// create stream from Object-List 
	              .filter(x -> x.getType().equals(type))		// 
	              .collect(Collectors.toList());
	  }
	
	
	@PostMapping
	public  String processDesign(
			@Valid @ModelAttribute("design") Taco design, 	// if name not class-name "design" (e.g. "taco")
			Errors errors,
			@ModelAttribute Order order) {   
		
		if(errors.hasErrors()) {
			return "design";
		}
		
		// ToDo: persistence - save taco creation 
		log.info("PPPPProcessing design: " + design.toString());
		
		Taco saved = designRepo.save(design);
		order.addDesign(saved);
		
		return "redirect:/orders/current";				// "redirect:" to forward user to new page
	}
}
