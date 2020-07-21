package org.taco.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.Errors; 

import org.taco.model.Order;


@Controller
@RequestMapping("/orders")
public class OrderController {
	
	/*
	 * Logger to protocol details of transmitting order
	 */
	private static final Logger log = Logger.getLogger(OrderController.class.getName());	
	
	@GetMapping("/current")
	public String orderForm(Model model) {
		model.addAttribute("order", new Order());
		return "orderForm";		// View name (orderForm.hmtl)
	}
	

	@PostMapping //("/orders")
	public String processOrder(Order order) {
		log.info("Order submitted: " + order.toString());
		return "redicrect:/";
	}
	
}
