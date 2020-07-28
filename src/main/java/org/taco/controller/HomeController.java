package org.taco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.taco.model.Order;

@Controller           
public class HomeController {

  @GetMapping("/")  	   
  public String home() {
    return "home";
  }
 
}
