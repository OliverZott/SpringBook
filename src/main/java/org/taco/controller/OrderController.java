package org.taco.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.taco.data.OrderRepository;
import org.taco.model.Order;


@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {
	
	// Logger to protocol details of transmitting order
	private static final Logger log = Logger.getLogger(OrderController.class.getName());

	private final OrderRepository orderRepo;

	public OrderController(OrderRepository orderRepository) {
		this.orderRepo = orderRepository;
	}

	@GetMapping("/current")
	public String orderForm(Model model) {
		model.addAttribute("order", new Order());
		return "orderForm";		// View name (orderForm.hmtl)
	}
	

	@PostMapping 		//("/orders")
	public String processOrder(@Valid @ModelAttribute("order") Order order, Errors errors,
							   SessionStatus sessionStatus) {
		if (errors.hasErrors()) {
			return "orderForm";
		}
		orderRepo.save(order);
		sessionStatus.isComplete();
		log.info("Order submitted: " + order.toString());
		return "redirect:/";
	}
	
}
